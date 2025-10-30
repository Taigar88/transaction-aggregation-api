package com.example.txagg.service;

import com.example.txagg.dto.TransactionDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component("mockA")
public class MockDataSourceA {

    //To build data for ref by API and push to postgres

    public List<TransactionDto> fetchRecent() {
        TransactionDto t1 = new TransactionDto();
        t1.customerId = "cust-1";
        t1.timestamp = Instant.now().minusSeconds(3600);
        t1.transactionAmount = new BigDecimal("-14.50");
        t1.transactionDescription = "Star Market - Groceries";
        t1.transactionSource = "mockA";

        TransactionDto t2 = new TransactionDto();
        t2.customerId = "cust-2";
        t2.timestamp = Instant.now().minusSeconds(7200);
        t2.transactionAmount = new BigDecimal("1500.00");
        t2.transactionDescription = "ACME Corp Salary";
        t2.transactionSource = "mockA";

        return List.of(t1, t2);
    }
}
