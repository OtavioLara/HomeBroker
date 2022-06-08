package com.inter.investing.exceptions;

import com.inter.investing.Customer;

public class CustomerAlreadyExistsException extends CustomerException{
    public CustomerAlreadyExistsException(Customer customer){
        super(customer, "already exists in the database");
    }
}
