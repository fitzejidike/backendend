package com.skilledservice.ClientService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Notification {
    @Id
    private Long notificationId;
    private Long userId;
    private String message;
    private String Status;

}
