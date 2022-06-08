package com.inter.investing.exceptions;

import com.inter.investing.Customer;

public abstract class CustomerException extends RuntimeException{
    private Customer customer;
    private String message;
    public CustomerException(Customer customer, String message) {
        this.customer = customer;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.customer + " --> " + message;
    }
}
