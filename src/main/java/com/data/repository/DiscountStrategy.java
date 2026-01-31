package com.data.repository;

import com.data.models.DiscountContext;
import com.data.models.DiscountResult;

public interface DiscountStrategy {

    boolean isApplicable(DiscountContext context);

    DiscountResult calculateDiscount(DiscountContext context);

    int getPriority();

    default String getStrategyName() {
        return this.getClass().getSimpleName();
    }

    default void validateContext(DiscountContext context) {
        if (context == null) {
            throw new NullPointerException("DiscountContext cannot be null");
        }
        if (context.getTransactionAmount() == null) {
            throw new IllegalArgumentException("Transaction amount cannot be null");
        }
        if (context.getCustomer() == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    default DiscountResult applyDiscount(DiscountContext context) {
        validateContext(context);

        if (!isApplicable(context)) {
            throw new IllegalStateException(
                    String.format("Strategy %s is not applicable for this context", getStrategyName())
            );
        }

        return calculateDiscount(context);
    }
}