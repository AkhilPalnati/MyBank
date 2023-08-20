package com.banking.java.dto;

import java.math.BigDecimal;

public class TransactionCreateRequest {
    private BigDecimal amount;
    // Other transaction attributes...

    // Getters and setters...

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return null;
    }

    // Other getter and setter methods for additional attributes...
}

