package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.RegisterClientRequest;
import com.skilledservice.ClientService.dto.responses.RegisterClientResponse;
import com.skilledservice.ClientService.model.Address;
import com.skilledservice.ClientService.model.Role;
import com.skilledservice.ClientService.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


import static com.skilledservice.ClientService.util.TestUtils.bulidRegisterClientRequest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts = "/db/data.sql")
class ClientServiceImplTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void registerClientTest(){
        RegisterClientRequest request = bulidRegisterClientRequest();
        RegisterClientResponse response = clientService.registerClient(request);
        assertNotNull(response);
        Assertions.assertThat(response.getMessage().contains("registered successfully"));
        
    }

}