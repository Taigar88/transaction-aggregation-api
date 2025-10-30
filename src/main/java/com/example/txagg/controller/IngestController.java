package com.example.txagg.controller;


import com.example.txagg.service.IngestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingest")
public class IngestController {
    private final IngestService ingestService;

    public IngestController(IngestService ingestService) {
        this.ingestService = ingestService;
    }

    @PostMapping("/run")
    public ResponseEntity<String> runIngest() {
        int saved = ingestService.ingestAll();
        return ResponseEntity.ok("Ingested " + saved + " transactions");
    }
}
