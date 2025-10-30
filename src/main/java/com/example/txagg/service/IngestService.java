package com.example.txagg.service;

import com.example.txagg.dto.TransactionDto;
import com.example.txagg.util.Mapper;
import com.example.txagg.model.Transaction;
import com.example.txagg.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngestService {
    private final MockDataSourceA mockA;
    private final MockDataSourceB mockB;
    private final CategorizerService categorized;
    private final TransactionRepository repository;

    public IngestService(MockDataSourceA mockA, MockDataSourceB mockB,
                         CategorizerService categorizer,
                         TransactionRepository repository) {
        this.mockA = mockA;
        this.mockB = mockB;
        this.categorized = categorizer;
        this.repository = repository;
    }

    @Transactional
    public int ingestAll() {
        List<TransactionDto> a = mockA.fetchRecent();
        List<TransactionDto> b = mockB.fetchRecent();
        List<TransactionDto> all = List.copyOf(a);
        all = concat(all, b);

        List<Transaction> entities = all.stream()
                .map(Mapper::toTransaction)
                .peek(t -> t.setCategory(categorized.categorize(t.getDescription(), t.getCustomerId())))
                .collect(Collectors.toList());

        repository.saveAll(entities);
        return entities.size();
    }

    private <T> List<T> concat(List<T> a, List<T> b) {
        return java.util.stream.Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
    }
}
