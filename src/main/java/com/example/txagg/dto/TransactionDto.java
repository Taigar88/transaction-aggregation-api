package com.example.txagg.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionDto {
    public String transactionId;
    public String customerId;
    public Instant timestamp;
    public BigDecimal transactionAmount;
    public String transactionDescription;
    public String transactionSource;

}
