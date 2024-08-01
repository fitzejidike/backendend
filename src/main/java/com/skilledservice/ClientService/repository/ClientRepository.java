package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
