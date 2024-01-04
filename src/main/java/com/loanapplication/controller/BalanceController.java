package com.loanapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loanapplication.model.AccountTransactions;
import com.loanapplication.model.Customer;
import com.loanapplication.repository.AccountTransactionsRepository;
import com.loanapplication.repository.CustomerRepository;

import java.util.List;

@RestController
public class BalanceController {

	 @Autowired
	 private CustomerRepository customerRepository;
     @Autowired
     private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String  email) {
    	List<Customer> customers = customerRepository.findByEmail(email);
    	if (customers != null && !customers.isEmpty()) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
        if (accountTransactions != null ) {
            return accountTransactions;
        }
        }
            return null;
        }
    }

