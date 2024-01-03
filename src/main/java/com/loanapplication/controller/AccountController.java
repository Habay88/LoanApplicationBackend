package com.loanapplication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loanapplication.model.Accounts;
import com.loanapplication.model.Customer;
import com.loanapplication.repository.AccountsRepository;
import com.loanapplication.repository.CustomerRepository;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String  email) {
    	List<Customer> customers = customerRepository.findByEmail(email);
    	if(customers != null && !customers.isEmpty()) {
        Accounts accounts = accountsRepository.findByCustomerId(customers.get(0).getId());
        if (accounts != null ) {
            return accounts;
    
        }
    }
		return null;
    }
}
