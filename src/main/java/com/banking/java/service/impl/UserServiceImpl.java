package com.banking.java.service.impl;

import com.banking.java.dto.AccountInfo;
import com.banking.java.dto.BankResponse;
import com.banking.java.dto.UserRequest;
import com.banking.java.entity.User;
import com.banking.java.repository.UserRepository;
import com.banking.java.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * Creating an account and saving the user into DB
         */
       if(userRepository.existsByEmail(userRequest.getEmail())){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
       }

        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .address(userRequest.getAddress())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .status("ACTIVE")
                .build();
            User savedUser = userRepository.save(newUser);
            return  BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                    .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                    .accountInfo(AccountInfo.builder()
                            .accountBalance(savedUser.getAccountBalance())
                            .accountNumber(savedUser.getAccountNumber())
                            .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
                            .build())
                    .build();
    }

    @Override
    public BankResponse getAccountDetails(String accountNumber) {
        // Retrieve user from the database using the account number
        User user = userRepository.findByAccountNumber(accountNumber);

        // If user not found, return appropriate response
        if (user == null) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_FOUND_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_FOUND_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        // Construct account info from user and return the response
        AccountInfo accountInfo = AccountInfo.builder()
                .accountBalance(user.getAccountBalance())
                .accountNumber(user.getAccountNumber())
                .accountName(user.getFirstName() + " " + user.getLastName())
                .build();

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_DETAILS_RETRIEVAL_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_DETAILS_RETRIEVAL_MESSAGE)
                .accountInfo(accountInfo)
                .build();
    }
}
