package com.example.txagg.service;

import com.example.txagg.dto.AggregationResponse;
import com.example.txagg.model.Category;
import com.example.txagg.model.Transaction;
import com.example.txagg.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class AggregationService {
    private final TransactionRepository repo;

    public AggregationService(TransactionRepository repo) {
        this.repo = repo;
    }

    public AggregationResponse aggregateForCustomer(String customerId, Instant from, Instant to) {
        List<Transaction> list = repo.findByCustomerIdAndTimestampBetween(customerId, from, to);

        Map<Category, BigDecimal> totals = list.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.mapping(Transaction::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        // ensure all categories present
        EnumMap<Category, BigDecimal> full = new EnumMap<>(Category.class);
        for (Category c : Category.values()) {
            full.put(c, totals.getOrDefault(c, BigDecimal.ZERO));
        }

        AggregationResponse resp = new AggregationResponse();
        resp.customerId = customerId;
        resp.fromEpoch = from.getEpochSecond();
        resp.toEpoch = to.getEpochSecond();
        resp.totalsByCategory = full;
        return resp;
    }
}
