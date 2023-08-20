package com.banking.java.controller;

import com.banking.java.dto.TransactionCreateRequest;
import com.banking.java.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<String> createTransaction(
            @RequestParam Long userId,
            @RequestBody TransactionCreateRequest transactionRequest) {
        transactionService.createTransaction(userId, transactionRequest);
        return ResponseEntity.ok("Transaction created successfully");
    }
}
