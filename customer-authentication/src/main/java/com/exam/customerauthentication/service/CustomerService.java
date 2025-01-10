package com.exam.customerauthentication.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.customerauthentication.model.Customer;
import com.exam.customerauthentication.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository crepo;

	public Customer saveUser(Customer cust) {
		cust.setPassword(passwordEncoder(cust.getPassword()));
		return crepo.save(cust);
	}
	
	public Optional<Customer> findEmail(String email) {
		
		return crepo.findByEmail(email);
	}

	public List<Customer> allCustomer() {
		return crepo.findAll();
		
	}
	
	public String passwordEncoder(String pass) {
		return Base64.getEncoder().encodeToString(pass.getBytes());
	}
	
	public String passWordDecoder(String pass) {
		return new String(Base64.getDecoder().decode(pass));
	}
}
