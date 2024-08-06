package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.CancelAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegisterClientRequest;
import com.skilledservice.ClientService.dto.responses.BookAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.GetAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.RegisterClientResponse;
import com.skilledservice.ClientService.model.Client;

import java.util.List;

public interface ClientService {
    RegisterClientResponse registerClient(RegisterClientRequest registerClientRequest);
    BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest);
    CancelAppointmentResponse cancelAppointment(CancelAppointmentRequest cancelAppointmentRequest);
    List<GetAppointmentResponse> getAllAppointmentsFor(Long Id);

}
