package com.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponse {
    private String transactionReference;
    private String sourceAccount;
    private String destinationAccount;
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal discountAmount;
    private BigDecimal discountPercentage;
    private BigDecimal finalAmount;
    private String status;
    private LocalDateTime transactionDate;
    private String narration;
    private String discountReason;
}