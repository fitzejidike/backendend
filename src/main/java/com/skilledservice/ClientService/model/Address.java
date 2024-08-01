package com.skilledservice.ClientService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    private Long id;
    private String streetNumber;
    private String streetName;
    private String area;
    @ManyToOne
    private User user;

}
