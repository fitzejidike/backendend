package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.model.SkilledWorkers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkilledWorkersRepository extends JpaRepository<SkilledWorkers, Long> {
}
