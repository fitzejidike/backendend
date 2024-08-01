package com.skilledservice.ClientService.repository;

import com.skilledservice.ClientService.model.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
}
