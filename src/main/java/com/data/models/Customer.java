package com.data.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;
}