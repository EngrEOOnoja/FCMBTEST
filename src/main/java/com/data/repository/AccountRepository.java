package com.data.repository;

import com.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

    @Query("SELECT a FROM Account a JOIN FETCH a.customer WHERE a.accountNumber = :accountNumber")
    Optional<Account> findByAccountNumberWithCustomer(@Param("accountNumber") String accountNumber);
}