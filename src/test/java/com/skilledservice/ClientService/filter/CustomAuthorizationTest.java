//package com.skilledservice.ClientService.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//import java.util.Date;
//
//
//import static org.springframework.test.web.servlet.requests.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomAuthorizationTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        SecurityContextHolder.clearContext();
//    }
//
//    private String generateToken(String username, String role) {
//        return JWT.create()
//                .withIssuer("connection")
//                .withClaim("roles", Collections.singletonList(role))
//                .withExpiresAt(new Date(System.currentTimeMillis() + 60000))
//                .sign(Algorithm.HMAC512("secret".getBytes()));
//    }
//
//
//
//    @Test
//    public void testPublicEndpoint() throws Exception {
//        mockMvc.perform(post("/public"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    public void testValidToken() throws Exception {
//        String token = generateToken("john.doe@example.com", "ROLE_USER");
//
//        mockMvc.perform(post("/api/v1/protected-endpoint")
//                        .header("Authorization", "Bearer " + token))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    public void testNoAuthorizationHeader() throws Exception {
//        mockMvc.perform(post("/api/v1/protected-endpoint"))
//                .andExpect(status().isForbidden())
//                .andDo(print());
//    }
//
//    @Test
//    public void testInvalidToken() throws Exception {
//        mockMvc.perform(post("/api/v1/protected-endpoint")
//                        .header("Authorization", "Bearer invalidtoken"))
//                .andExpect(status().isForbidden())
//                .andDo(print());
//    }
//}
