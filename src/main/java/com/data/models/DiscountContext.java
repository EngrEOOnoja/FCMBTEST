package com.data.models;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Value
    @Builder
    public class DiscountContext {
        Customer customer;
        String accountNumber;
        BigDecimal transactionAmount;
        TransactionType transactionType;
        LocalDateTime transactionDate;
        long transactionCountThisMonth;
        long nonAirtimeTransactionCountThisMonth;
    }