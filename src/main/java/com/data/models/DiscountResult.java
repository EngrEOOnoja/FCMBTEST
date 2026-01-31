package com.data.models;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class DiscountResult {

    BigDecimal discountPercentage;
    BigDecimal discountAmount;
    BigDecimal finalAmount;
    String discountReason;

    public static DiscountResult noDiscount(BigDecimal amount) {
        return DiscountResult.builder()
                .discountPercentage(BigDecimal.ZERO)
                .discountAmount(BigDecimal.ZERO)
                .finalAmount(amount)
                .discountReason("No discount applicable")
                .build();
    }

    public boolean hasDiscount() {
        return discountAmount != null && discountAmount.compareTo(BigDecimal.ZERO) > 0;
    }
}