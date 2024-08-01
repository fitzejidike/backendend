package com.skilledservice.ClientService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    private Long reviewId;
    private Long clientId;
}
