package com.example.txagg.util;

import com.example.txagg.dto.TransactionDto;
import com.example.txagg.model.Transaction;

public class Mapper {
    public static Transaction toTransaction(TransactionDto transaction) {
        Transaction transaction1 = new Transaction();
        if (transaction != null) {
            transaction1.setId(transaction.transactionId);
            transaction1.setCustomerId(transaction.customerId);
            transaction1.setTimestamp(transaction.timestamp);
            transaction1.setAmount(transaction.transactionAmount);
            transaction1.setDescription(transaction.transactionDescription);
            transaction1.setSource(transaction.transactionSource);
        }
        return transaction1;
    }
}
