package com.skilledservice.ClientService.security.config;

import com.skilledservice.ClientService.security.provider.CustomerAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//
//  @Bean
//    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
//
//        return new CustomerAuthenticationProvider(userDetailsService, passwordEncoder());
//  }
}
