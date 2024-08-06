package com.skilledservice.ClientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long adminId;
    @OneToOne
    private User user;
    @OneToOne
    private SkilledWorkers skilledWorkers;
    @OneToOne
    private Client client;
}
