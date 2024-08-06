package com.skilledservice.ClientService.dto.responses;

import com.skilledservice.ClientService.model.Appointment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAppointmentResponse {
    List<Appointment> appointments;
}
