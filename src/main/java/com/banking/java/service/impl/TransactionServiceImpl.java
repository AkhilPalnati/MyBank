package com.banking.java.service.impl;

import com.banking.java.dto.AccountInfo;
import com.banking.java.dto.BankResponse;
import com.banking.java.dto.TransactionCreateRequest;
import com.banking.java.entity.TransactionEntity; // Import the correct TransactionEntity class
import com.banking.java.entity.User;
import com.banking.java.repository.TransactionRepository;
import com.banking.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Component
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createTransaction(Long userId, TransactionCreateRequest transactionRequest) {
        // Your implementation for createTransaction with userId
    }

    @Override
    public BankResponse createTransaction(String accountNumber, TransactionCreateRequest transactionRequest) {
        User user = userRepository.findByAccountNumber(accountNumber);

        // Rest of your existing code...
        // Create a new TransactionEntity and populate its attributes
        TransactionEntity transaction = new TransactionEntity();
        transaction.setUser(user);
        transaction.setAccountNumber(user.getAccountNumber());
        BigDecimal transactionAmount = transactionRequest.getAmount(); // Get transaction amount from request
        transaction.setAmount(transactionAmount);
        transaction.setTransactionType(transactionRequest.getTransactionType());
// Set other attributes...


        // Save the transaction entity and update user's account balance
        transactionRepository.save(transaction);
        userRepository.save(user);

        // Rest of your existing code...
        return BankResponse.builder()
                .responseCode("200")
                .responseMessage("Transaction created successfully")
                .accountInfo(AccountInfo.builder()
                        .accountBalance(user.getAccountBalance())
                        .accountNumber(user.getAccountNumber())
                        .accountName(user.getFirstName() + " " + user.getLastName())
                        .build())
                .build();
    }

    // Other methods...
}
