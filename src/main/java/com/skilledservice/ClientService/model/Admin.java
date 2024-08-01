package com.skilledservice.ClientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {
    @Id
    private Long adminId;
    @OneToOne
    private User user;
    @OneToOne
    private SkilledWorkers skilledWorkers;
    @OneToOne
    private Client client;
}
