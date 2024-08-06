package com.skilledservice.ClientService.util;

import com.skilledservice.ClientService.dto.requests.RegisterClientRequest;
import com.skilledservice.ClientService.model.Address;
import com.skilledservice.ClientService.model.Role;

public class TestUtils {
    public static RegisterClientRequest bulidRegisterClientRequest(){
        RegisterClientRequest request = new RegisterClientRequest();
        request.setRole(Role.CLIENT);
        request.setUsername("fitz");
        request.setPassword("12345");
        Address address = new Address();
        address.setArea("416 wemco rd");
        address.setArea("ikeja");
        request.setAddress(address);
        return request;
    }
}
