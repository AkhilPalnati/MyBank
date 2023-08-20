package com.banking.java.controller;

import com.banking.java.dto.BankResponse;
import com.banking.java.dto.TransactionUpdate;
import com.banking.java.dto.UserRequest;
import com.banking.java.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
@PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
    return userService.createAccount(userRequest);
}

    @GetMapping("/{accountNumber}")
    public BankResponse getAccountDetails(@PathVariable String accountNumber) {
        return userService.getAccountDetails(accountNumber);
    }
    @PostMapping("/{accountNumber}/update-transaction")
    public BankResponse updateTransaction(
            @PathVariable String accountNumber,
            @RequestBody TransactionUpdate transactionUpdate) {
        return userService.updateTransaction(accountNumber, transactionUpdate);
    }

}

