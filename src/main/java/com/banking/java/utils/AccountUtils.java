package com.banking.java.utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "THIS ACCOUNT ALREADY EXISTS";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "USER HAS BEEN CREATED SUCCESSFULLY";
    public static final String ACCOUNT_NOT_FOUND_CODE = "123";
    public static final String ACCOUNT_NOT_FOUND_MESSAGE = "NO USER";
    public static final String ACCOUNT_DETAILS_RETRIEVAL_SUCCESS = "111";
    public static final String ACCOUNT_DETAILS_RETRIEVAL_MESSAGE = "SUCCESS";

    public static String generateAccountNumber(){

        Year currentYear = Year.now();
        int min = 100000;
        int max= 999999;
        int randNumber = (int) Math.floor(Math.random() * (max - min + 1 ) + min);
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();
       return accountNumber.append(year).append(randomNumber).toString();


    }


}
