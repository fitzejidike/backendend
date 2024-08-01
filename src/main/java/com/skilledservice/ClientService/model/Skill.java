package com.skilledservice.ClientService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Skill {
    @Id
    private Long id;
    private String skillName;
    private String experience;
    private BigDecimal rate;
}
