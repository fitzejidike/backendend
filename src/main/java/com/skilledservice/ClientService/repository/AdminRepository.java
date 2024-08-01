package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
