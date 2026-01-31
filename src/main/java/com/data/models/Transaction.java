package com.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions", indexes = {
        @Index(name = "idx_source_account", columnList = "sourceAccount"),
        @Index(name = "idx_transaction_date", columnList = "transactionDate")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String transactionReference;

    @Column(nullable = false)
    private String sourceAccount;

    @Column
    private String destinationAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(precision = 19, scale = 2)
    @Builder.Default
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(precision = 5, scale = 2)
    @Builder.Default
    private BigDecimal discountPercentage = BigDecimal.ZERO;

    @Column(precision = 19, scale = 2)
    private BigDecimal finalAmount;

    @Column
    private String networkProvider;

    @Column
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @Column(length = 500)
    private String narration;

    @Column(length = 1000)
    private String discountReason;
}