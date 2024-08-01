package com.skilledservice.ClientService.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.skilledservice.ClientService.dto.requests.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class AuthenticationControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
////    @Test
////    @Sql(scripts = {"/db/data.sql"})
////    public void authenticateUserTest() throws Exception {
////        LoginRequest loginRequest = new LoginRequest();
////        loginRequest.setUsername("john.doe@example.com");
////        loginRequest.setPassword("password");
////        ObjectMapper objectMapper = new ObjectMapper();
////        mockMvc.perform(post("/api/v1/auth")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsBytes(loginRequest)))
////                .andExpect(status().isOk())
////                .andDo(print());
////
////    }
//    @Test
//    @Sql(scripts = {"/db/data.sql"})
//    public void authenticateUserTest() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("john.doe@example.com");
//        loginRequest.setPassword("password");
//        ObjectMapper objectMapper = new ObjectMapper();
//        mockMvc.perform(post("/api/v1/auth")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsBytes(loginRequest)))
//                .andExpect(status().isOk())
//                .andDo(print());
//
//    }
//
//
//
//
//    @Test
//    public void testThatAuthenticationFailsForIncorrectCredentials() throws Exception {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("janesmith@example.com");
//        loginRequest.setPassword("password");
//        ObjectMapper objectMapper = new ObjectMapper();
//        mockMvc.perform(post("/api/v1/auth")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsBytes(loginRequest)))
//                .andExpect(status().isUnauthorized())
//                .andDo(print());
//    }
}






