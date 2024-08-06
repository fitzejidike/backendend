package com.skilledservice.ClientService.dto.requests;

import com.skilledservice.ClientService.model.SkilledWorkers;
import com.skilledservice.ClientService.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookAppointmentRequest {
    private String username;
    private Long id;



}
