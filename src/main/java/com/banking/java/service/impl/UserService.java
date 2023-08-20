package com.banking.java.service.impl;

import com.banking.java.dto.BankResponse;
import com.banking.java.dto.TransactionUpdate;
import com.banking.java.dto.UserRequest;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);
    BankResponse getAccountDetails(String accountNumber);

    BankResponse updateTransaction(String accountNumber, TransactionUpdate transactionUpdate);

}
