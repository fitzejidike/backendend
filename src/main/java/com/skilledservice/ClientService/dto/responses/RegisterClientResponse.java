package com.skilledservice.ClientService.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skilledservice.ClientService.model.Address;
import com.skilledservice.ClientService.model.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterClientResponse {
    @JsonProperty("Client_id")
    private  Long id;
    private  String username;
    private Address address;
    private Role role;
    private String message;
}
