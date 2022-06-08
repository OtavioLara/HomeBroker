package com.inter.investing.exceptions;

import com.inter.investing.Account;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Integer id){
        super("Account with id "+ id +" was not found");
    }
}
