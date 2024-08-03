package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.CancelAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegisterClientRequest;
import com.skilledservice.ClientService.dto.responses.BookAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.RegisterClientResponse;

public interface ClientService {
    RegisterClientResponse registerClient(RegisterClientRequest registerClientRequest);
    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest, Long id);
    CancelAppointmentResponse cancelAppointment(CancelAppointmentRequest cancelAppointmentRequest);

}
