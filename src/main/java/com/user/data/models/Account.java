package com.user.data.models;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Account {

    @Id
    private Long id;

    private String accountNumber;

    private Customer customer;

    private BigDecimal balance = BigDecimal.ZERO;

    private AccountType accountType;

    private LocalDateTime createdAt;

    private Boolean active = true;

    public enum AccountType {
        SAVINGS,
        CURRENT,
        FIXED_DEPOSIT
    }
}