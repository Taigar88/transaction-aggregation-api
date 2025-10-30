package com.example.txagg.controller;

import com.example.txagg.dto.AggregationResponse;
import com.example.txagg.service.AggregationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/aggregations")

public class AggregationController {
    private final AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<AggregationResponse> byCustomer(
            @PathVariable String customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        return ResponseEntity.ok(aggregationService.aggregateForCustomer(customerId, from, to));
    }
}
