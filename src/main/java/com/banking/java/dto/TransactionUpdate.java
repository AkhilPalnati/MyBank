package com.banking.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionUpdate {

    private String transactionType;
    private BigDecimal amount;
}
