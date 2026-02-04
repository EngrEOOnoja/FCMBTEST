package com.services;

import com.data.models.TransactionType;
import com.data.models.DiscountContext;
import com.data.models.DiscountResult;
import com.data.repository.DiscountStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Period;

@Component
public class LoyaltyDiscountStrategy implements DiscountStrategy {

    private static final BigDecimal LOYALTY_DISCOUNT_PERCENTAGE = new BigDecimal("10");
    private static final int REQUIRED_YEARS = 4;
    private static final long MAX_DISCOUNTED_TRANSACTIONS = 3;

    @Override
    public boolean isApplicable(DiscountContext context) {
        if (context.getTransactionType() == TransactionType.AIRTIME_PURCHASE) {
            return false;
        }

        LocalDateTime registrationDate = context.getCustomer().getRegistrationDate();
        LocalDateTime currentDate = context.getTransactionDate();
        Period period = Period.between(registrationDate.toLocalDate(), currentDate.toLocalDate());

        if (period.getYears() < REQUIRED_YEARS) {
            return false;
        }

        return context.getNonAirtimeTransactionCountThisMonth() < MAX_DISCOUNTED_TRANSACTIONS;
    }

    @Override
    public DiscountResult calculateDiscount(DiscountContext context) {
        BigDecimal amount = context.getTransactionAmount();
        BigDecimal discountAmount = amount
                .multiply(LOYALTY_DISCOUNT_PERCENTAGE)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);

        BigDecimal finalAmount = amount.subtract(discountAmount);

        long transactionNumber = context.getNonAirtimeTransactionCountThisMonth() + 1;

        return DiscountResult.builder()
                .discountPercentage(LOYALTY_DISCOUNT_PERCENTAGE)
                .discountAmount(discountAmount)
                .finalAmount(finalAmount)
                .discountReason(String.format(
                        "Loyalty discount: 10%% for customers with 4+ years (Transaction %d of 3 eligible this month)",
                        transactionNumber
                ))
                .build();
    }

    @Override
    public int getPriority() {
        return 1;
    }
}