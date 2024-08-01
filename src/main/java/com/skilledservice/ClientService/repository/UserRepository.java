package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.exception.UserNotFoundException;
import com.skilledservice.ClientService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select  u from User u where u.email =:email")
//    Optional<User> findByEmail(String email) throws UserNotFoundException;

    Optional<User> findByUsername(String username);
}
