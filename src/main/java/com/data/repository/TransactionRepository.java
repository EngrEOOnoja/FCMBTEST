package com.data.repository;

import com.data.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySourceAccountOrderByTransactionDateDesc(String sourceAccount);

    @Query("SELECT t FROM Transaction t WHERE t.sourceAccount = :accountNumber " +
            "AND t.transactionDate >= :startDate AND t.transactionDate <= :endDate " +
            "AND t.status = 'SUCCESSFUL' " +
            "ORDER BY t.transactionDate DESC")
    List<Transaction> findSuccessfulTransactionsByAccountAndDateRange(
            @Param("accountNumber") String accountNumber,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.sourceAccount = :accountNumber " +
            "AND t.transactionDate >= :startDate AND t.transactionDate <= :endDate " +
            "AND t.status = 'SUCCESSFUL'")
    long countSuccessfulTransactionsByAccountInMonth(
            @Param("accountNumber") String accountNumber,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.sourceAccount = :accountNumber " +
            "AND t.transactionDate >= :startDate AND t.transactionDate <= :endDate " +
            "AND t.status = 'SUCCESSFUL' AND t.transactionType <> 'AIRTIME_PURCHASE'")
    long countNonAirtimeTransactionsByAccountInMonth(
            @Param("accountNumber") String accountNumber,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    boolean existsByTransactionReference(String transactionReference);
}
