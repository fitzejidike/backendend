package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.model.User;

import java.util.Optional;

public interface UserService {
    User getUserByUsername(String username);


}
