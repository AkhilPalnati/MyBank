package com.banking.java.service.impl;

import com.banking.java.dto.BankResponse;
import com.banking.java.dto.TransactionCreateRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public interface TransactionService {
    void createTransaction(Long userId, TransactionCreateRequest transactionRequest);

    BankResponse createTransaction(String accountNumber, TransactionCreateRequest transactionRequest);
}
