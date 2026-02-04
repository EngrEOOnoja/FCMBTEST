package com.user.data.repository;

import com.user.data.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findBySourceAccountOrderByTransactionDateDesc(String sourceAccount);


    @Query("{ 'sourceAccount': ?0, 'transactionDate': { '$gte': ?1, '$lte': ?2 }, 'status': 'SUCCESSFUL' }")
    List<Transaction> findSuccessfulTransactionsByAccountAndDateRange(
            String accountNumber,
            LocalDateTime startDate,
            LocalDateTime endDate
    );


    @Query(value = "{ 'sourceAccount': ?0, 'transactionDate': { '$gte': ?1, '$lte': ?2 }, 'status': 'SUCCESSFUL' }", count = true)
    long countSuccessfulTransactionsByAccountInMonth(
            String accountNumber,
            LocalDateTime startDate,
            LocalDateTime endDate
    );


    @Query(value = "{ 'sourceAccount': ?0, 'transactionDate': { '$gte': ?1, '$lte': ?2 }, 'status': 'SUCCESSFUL', 'transactionType': { '$ne': 'AIRTIME_PURCHASE' } }", count = true)
    long countNonAirtimeTransactionsByAccountInMonth(
            String accountNumber,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    boolean existsByTransactionReference(String transactionReference);
}