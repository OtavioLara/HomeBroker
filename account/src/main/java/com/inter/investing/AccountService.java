package com.inter.investing;

import com.inter.investing.exceptions.AccountNotFoundException;
import com.inter.investing.exceptions.CustomerAlreadyExistsException;
import com.inter.investing.exceptions.CustomerNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public record AccountService(
        AccountRepository accountRepository,
        CustomerRepository customerRepository) {
    public void registryAccount(AccountDTO accountDTO) {
        Customer customer = Customer.builder()
                .name(accountDTO.customerDTO().name())
                .cpf(accountDTO.customerDTO().cpf())
                .email(accountDTO.customerDTO().email())
                .build();
        Example<Customer> example = Example.of(
                customer,
                ExampleMatcher.matching()
                        .withIgnorePaths("id")
                        .withMatcher("cpf", ignoreCase())
        );
        if (customerRepository.findAll(example).stream().toList().isEmpty()) {
            Account account = Account.builder()
                    .customer(customer)
                    .password(accountDTO.password())
                    .build();
            customerRepository.save(customer);
            accountRepository.save(account);
        } else {
            throw new CustomerAlreadyExistsException(customer);
        }
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Integer id) throws AccountNotFoundException {
        var account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }else{
            throw new CustomerNotFoundException(id);
        }
    }

}
