package com.skilledservice.ClientService.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SkilledWorkers {
    @Id

    private Long skilledWorkerId;
    @OneToOne
    private User user;
    private Category category;
    @ManyToOne
    private Admin admin;


}
