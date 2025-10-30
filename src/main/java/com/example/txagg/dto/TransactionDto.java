package com.example.txagg.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

// @TAI Standard form I always use this for dto and models to standardize, also @Builder

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {
    public String transactionId;
    public String customerId;
    public Instant timestamp;
    public BigDecimal transactionAmount;
    public String transactionDescription;
    public String transactionSource;

}
