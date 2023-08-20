package com.banking.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Add this property to represent the user associated with the transaction

    private String accountNumber;
    private BigDecimal amount;
    private String transactionType;

    // Other getters and setters...
}
