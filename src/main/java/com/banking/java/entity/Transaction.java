package com.banking.java.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Establish many-to-one relationship with User
    @JoinColumn(name = "user_id") // Define the join column
    private User user;

    private String accountNumber;
    private BigDecimal amount;
    private String transactionType;

}


