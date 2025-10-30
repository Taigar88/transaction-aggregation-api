package com.example.txagg.repository;
import com.example.txagg.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
  List<Transaction> findByCustomerIdAndTimestampBetween(String customerId, Instant from, Instant to);
  List<Transaction> findByCustomerId(String customerId);
  List<Transaction> findByTimestampBetween(Instant from, Instant to);
}
