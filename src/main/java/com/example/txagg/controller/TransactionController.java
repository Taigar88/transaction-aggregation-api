package com.example.txagg.controller;

import com.example.txagg.model.Transaction;
import com.example.txagg.repository.TransactionRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<List<Transaction>> byCustomer(
            @PathVariable String customerId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        if (from != null && to != null) {
            return ResponseEntity.ok(repo.findByCustomerIdAndTimestampBetween(customerId, from, to));
        } else {
            return ResponseEntity.ok(repo.findByCustomerId(customerId));
        }
    }

    @GetMapping("/between")
    public ResponseEntity<List<Transaction>> between(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        return ResponseEntity.ok(repo.findByTimestampBetween(from, to));
    }
}
