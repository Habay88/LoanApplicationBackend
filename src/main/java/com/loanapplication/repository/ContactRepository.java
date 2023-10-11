package com.loanapplication.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loanapplication.model.Contact;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
