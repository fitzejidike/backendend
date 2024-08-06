package com.skilledservice.ClientService.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Client{
    @Id
    private Long clientId;
    private String password;
    @OneToOne
    private User user;

    @OneToOne
    private Admin admin;
    @OneToMany
    private List<Appointment>appointments;


//    @Service
//    @AllArgsConstructor
//    @Slf4j
//    public class CustomUserDetailsService implements UserDetailsService {
//
//        private final UserService userService;
//
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            try{
//                log.info("username: {}", username);
//                User user = userService.getUserByUsername(username);
//                return new SecureUser(user);
//            } catch (UserNotFoundException e) {
//                throw new RuntimeException(e.getMessage());
//            }
//        }
//
//    }


}
