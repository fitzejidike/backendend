package com.skilledservice.ClientService.security.manager;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    private final AuthenticationProvider authenticationProvider;
    @Autowired
    public CustomAuthenticationManager(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            Class<? extends Authentication> authenticationType = authentication.getClass();
            if(authenticationProvider.supports(authenticationType))
                return authenticationProvider.authenticate(authentication);
            else throw new BadCredentialsException("Invalid credentials");


    }
}

