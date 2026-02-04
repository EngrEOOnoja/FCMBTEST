package com.user.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Customer {

    @Id
    private Long id;

    private String name;

    private String customerId;

    private CustomerType customerType;

    private LocalDateTime registrationDate;

    private List<Account> accounts = new ArrayList<>();

    private Boolean active = true;

    public enum CustomerType {
        BUSINESS,
        RETAIL
    }
}