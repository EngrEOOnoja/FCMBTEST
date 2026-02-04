package com.user.data.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Transaction {


    private Long id;

    private String transactionReference;

    private String sourceAccount;

    private String destinationAccount;

    private TransactionType transactionType;

    private BigDecimal amount;

    private BigDecimal discountAmount = BigDecimal.ZERO;

    private BigDecimal discountPercentage = BigDecimal.ZERO;

    private BigDecimal finalAmount;

    private String networkProvider;

    private String phoneNumber;

    private TransactionStatus status;

    private LocalDateTime transactionDate;

    private String narration;

    private String discountReason;

    public enum TransactionType {
        TRANSFER,
        AIRTIME_PURCHASE
    }

    public enum TransactionStatus {
        PENDING,
        SUCCESSFUL,
        FAILED
    }
}