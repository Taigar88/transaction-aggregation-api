package com.example.txagg.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
@Entity
@Getter
@Setter
@Table(name = "transactions" , indexes ={@Index(name = "idx_customer_timestamp", columnList = "customerId,timestamp")})
public class Transaction {
  @Id private String id = UUID.randomUUID().toString();
  private String customerId;
  private Instant timestamp;
  private BigDecimal amount;
  private String description;
  @Enumerated(EnumType.STRING)
  private Category category;
  private String source;
}
