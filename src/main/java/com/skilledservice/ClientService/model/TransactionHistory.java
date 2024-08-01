package com.skilledservice.ClientService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class TransactionHistory {
    @Id
    private Long customerId;
    private Long id;
    @ManyToMany
    private List<Transaction> transactions;
}
