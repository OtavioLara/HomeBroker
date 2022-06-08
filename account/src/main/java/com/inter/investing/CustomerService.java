package com.inter.investing;

import com.inter.investing.exceptions.CustomerNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public record CustomerService(CustomerRepository customerRepository){

    public Boolean registryCustomer(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .name(customerDTO.name())
                .cpf(customerDTO.cpf())
                .email(customerDTO.email())
                .build();
        Example<Customer> example = Example.of(
                customer,
                ExampleMatcher.matching()
                        .withIgnorePaths("id")
                        .withMatcher("cpf", ignoreCase())
        );
        if (customerRepository.findAll(example).stream().toList().isEmpty()) {
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) throws CustomerNotFoundException{
        var customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            throw new CustomerNotFoundException(id);
        }
    }
}
