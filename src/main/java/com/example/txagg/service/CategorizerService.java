package com.example.txagg.service;

import com.example.txagg.model.Category;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class CategorizerService {

    public Category categorize(String description, String customerId) {
        if (description == null) return Category.UNKNOWN;
        String d = description.toLowerCase(Locale.ROOT);

        if (d.contains("super") || d.contains("market") || d.contains("grocer") || d.contains("grocery")) {
            return Category.GROCERIES;
        }
        if (d.contains("bus") || d.contains("taxi") || d.contains("metro") || d.contains("transport")) {
            return Category.TRANSPORT;
        }
        if (d.contains("salary") || d.contains("payroll")) {
            return Category.SALARY;
        }
        if (d.contains("pizza") || d.contains("restaurant") || d.contains("cafe") || d.contains("starbucks")) {
            return Category.RESTAURANT;
        }
        if (d.contains("electric") || d.contains("water") || d.contains("utility") || d.contains("power")) {
            return Category.UTILITIES;
        }
        if (d.contains("netflix") || d.contains("movie") || d.contains("concert")) {
            return Category.ENTERTAINMENT;
        }
        if (d.contains("transfer") || d.contains("deposit") || d.contains("withdrawal")) {
            return Category.TRANSFER;
        }
        return Category.UNKNOWN;
    }
}
