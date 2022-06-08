package com.inter.investing.exceptions;

import com.inter.investing.Customer;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Integer id){
        super("Customer with id: "+id+" was not found");
    }
}
