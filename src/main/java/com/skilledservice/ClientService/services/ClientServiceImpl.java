package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.CancelAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegisterClientRequest;
import com.skilledservice.ClientService.dto.responses.BookAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.RegisterClientResponse;
import com.skilledservice.ClientService.model.Client;
import com.skilledservice.ClientService.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;


    @Override
    public RegisterClientResponse registerClient(RegisterClientRequest request) {
        Client client = modelMapper.map(request, Client.class);
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client = clientRepository.save(client);

        var response = modelMapper.map(client, RegisterClientResponse.class);
        response.setMessage("user registered successfully");
        return response;

    }

    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest, Long id) {
        return null;
    }

    @Override
    public CancelAppointmentResponse cancelAppointment(CancelAppointmentRequest cancelAppointmentRequest) {
        return null;
    }
}
