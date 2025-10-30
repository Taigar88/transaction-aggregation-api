package com.example.txagg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TransactionAggregatorApplication {
  public static void main(String[] args) {
    SpringApplication.run(TransactionAggregatorApplication.class, args);
  }
}
