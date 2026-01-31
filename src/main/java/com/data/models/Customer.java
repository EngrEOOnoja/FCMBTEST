package com.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime RegistrationDate;
}