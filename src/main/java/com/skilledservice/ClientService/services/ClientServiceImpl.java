package com.skilledservice.ClientService.services;

import com.skilledservice.ClientService.dto.requests.BookAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.CancelAppointmentRequest;
import com.skilledservice.ClientService.dto.requests.RegisterClientRequest;
import com.skilledservice.ClientService.dto.responses.BookAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.CancelAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.GetAppointmentResponse;
import com.skilledservice.ClientService.dto.responses.RegisterClientResponse;
import com.skilledservice.ClientService.exception.UserNotFoundException;
import com.skilledservice.ClientService.model.*;
import com.skilledservice.ClientService.repository.AppointmentRepository;
import com.skilledservice.ClientService.repository.ClientRepository;
import com.skilledservice.ClientService.repository.SkilledWorkersRepository;
import com.skilledservice.ClientService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final SkilledWorkersRepository skilledWorkersRepository;


    @Override
    public RegisterClientResponse registerClient(RegisterClientRequest request) {
        Client client = modelMapper.map(request, Client.class);
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client = clientRepository.save(client);

        var response = modelMapper.map(client, RegisterClientResponse.class);
        response.setMessage(" registered successfully");
        return response;

    }

    @Override
    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest) {
        Client client = clientRepository.findByUsername(bookAppointmentRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        Appointment appointment = modelMapper.map(bookAppointmentRequest, Appointment.class);
        appointment.setClient(client);
        appointment.setAppointmentStatus(AppointmentStatus.WAITING);
        appointmentRepository.save(appointment);


        Long id = bookAppointmentRequest.getId();
        SkilledWorkers workers = skilledWorkersRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        appointment.setWorkers(workers);
        client.getAppointments().add(appointment);
        clientRepository.save(client);

        BookAppointmentResponse response =
                modelMapper.map(client, BookAppointmentResponse.class);


        return null;
    }

    @Override
    public CancelAppointmentResponse cancelAppointment(CancelAppointmentRequest cancelAppointmentRequest) {
        return null;
    }

    @Override
    public List<GetAppointmentResponse> getAllAppointmentsFor(Long id) {
        List<Appointment> appointments = getUserById(id).getAppointment();
        Appointment appointment =
                modelMapper.map(GetAppointmentResponse, Appointment.class);
        return
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user not found "));
    }

    private getAppointments(Long id) {
        return clientRepository.findById(id).getAppointment
                .orElseThrow(() -> new UserNotFoundException("user not found"));
    }

}
