package com.example.txagg.dto;

import com.example.txagg.model.Category;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AggregationResponse {
    public String customerId;
    public Long fromEpoch;
    public Long toEpoch;
    public Map<Category, BigDecimal> totalsByCategory;
}
