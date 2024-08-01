package com.skilledservice.ClientService.security.filtersC;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilledservice.ClientService.dto.requests.LoginRequest;
import com.skilledservice.ClientService.dto.responses.BaseResponses;
import com.skilledservice.ClientService.dto.responses.LoginResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Collection;


public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper mapper = new ObjectMapper();
    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authManager){
        this.authenticationManager = authManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {

            InputStream requestBodyStream = request.getInputStream();
            LoginRequest loginRequest  =
                    mapper.readValue(requestBodyStream, LoginRequest.class);
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(username, password);

            Authentication authenticationResult = authenticationManager.authenticate(authentication);
            SecurityContextHolder. getContext().setAuthentication(authenticationResult);
            return authenticationResult;

        }catch (IOException exception){
            throw new BadCredentialsException(exception.getMessage());

        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(generateAccessToken(authResult));
        loginResponse.setMessage("Successful Authentication");
        BaseResponses<LoginResponse> authResponses = new BaseResponses<>();
        authResponses.setCode(HttpStatus.OK.value());
        authResponses.setData(loginResponse);
        authResponses.setStatus(true);

        response.getOutputStream().write(mapper.writeValueAsBytes(authResponses));
        response.flushBuffer();
        chain.doFilter(request,response);
    }

    private static String generateAccessToken(Authentication authResult) {
        return JWT.create()
                .withIssuer("client")
                .withArrayClaim("roles",
                        getClaimsFrom(authResult.getAuthorities()))
                .withExpiresAt(Instant.now().plusSeconds(24 * 60 * 60))
                .sign(Algorithm.HMAC512("secret"));

    }

    private static String[] getClaimsFrom(Collection<? extends GrantedAuthority> authorities){
        return authorities.stream()
                .map((grantedAuthority)-> grantedAuthority.getAuthority())
                .toArray(String[]:: new);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException exception) throws IOException, ServletException {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(exception.getMessage());
        BaseResponses<LoginResponse>baseResponses = new BaseResponses<>();
        baseResponses.setData(loginResponse);
        baseResponses.setStatus(false);
        baseResponses.setCode(HttpStatus.UNAUTHORIZED.value());

        response.getOutputStream().
                write(mapper.writeValueAsBytes(baseResponses));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.flushBuffer();


    }
}
