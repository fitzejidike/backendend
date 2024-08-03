package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.model.Address;
import com.skilledservice.ClientService.model.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterClientRequest {
    private String password;
    private String username;
    private Address address;
    private Role role;
}
