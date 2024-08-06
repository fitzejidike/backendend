package com.skilledservice.ClientService.model;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;


@Setter
@Getter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long transactionId;
    private Long clientId;
    private Long skilledWorkers;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime transactionDate;

}
