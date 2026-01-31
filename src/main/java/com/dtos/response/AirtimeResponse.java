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
    public class AirtimeResponse {
        private String transactionReference;
        private BigDecimal amount;
        private String networkProvider;
        private String phoneNumber;
        private String status;
        private String narration;
        }

