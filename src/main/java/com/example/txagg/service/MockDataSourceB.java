package com.example.txagg.service;

import com.example.txagg.dto.TransactionDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Component("mockB")
public class MockDataSourceB {
    public List<TransactionDto> fetchRecent() {
        TransactionDto t1 = new TransactionDto();
        t1.customerId = "cust-1";
        t1.timestamp = Instant.now().minusSeconds(1800);
        t1.transactionAmount = new BigDecimal("-3.20");
        t1.transactionDescription = "CityBus - Transport";
        t1.transactionSource = "mockB";

        TransactionDto t2 = new TransactionDto();
        t2.customerId = "cust-3";
        t2.timestamp = Instant.now().minusSeconds(3600*5);
        t2.transactionAmount = new BigDecimal("-35.00");
        t2.transactionDescription = "Bella's Pizza";
        t2.transactionSource = "mockB";

        return List.of(t1, t2);
    }
}
