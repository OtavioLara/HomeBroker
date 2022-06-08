package com.inter.investing.exceptions;

import com.inter.investing.Account;

public class AccountException extends RuntimeException{
    private Account account;
    private String message;
    public AccountException(Account account, String message) {
        this.account = account;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.account + " --> " + message;
    }
}
