package com.exam.customerauthentication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.customerauthentication.model.Customer;
import com.exam.customerauthentication.service.CustomerService;


@Controller
public class CustomerController 
{
	@Autowired
	CustomerService custServ;
 @PostMapping("/register")
 public ResponseEntity<String> postRegister(@Validated @RequestBody Customer customer) {
      
	 Customer cust = custServ.saveUser(customer);
	 if(cust != null) {
		 return new ResponseEntity<String>("user added Succesfully " , HttpStatus.OK);
	 }else {
		 return new ResponseEntity<String>("User not Added Try again" , HttpStatus.BAD_REQUEST);
	 }

 }
 
 @PostMapping("/login")
 public ResponseEntity<String> logiCustomer(@RequestBody Customer customer) {
     String email = customer.getEmail();
     String password = customer.getPassword();
     
     Optional<Customer> cs =  custServ.findEmail(email);
     
     Customer cust = cs.get();
     cust.setPassword(custServ.passWordDecoder(cust.getPassword()));
     
     if(email.equals(cust.getEmail()) && password.equals(cust.getPassword())) {
    	 return new ResponseEntity<String>("Login Successfull" , HttpStatus.OK);
     }else{
    	 return new ResponseEntity<String>("Incorrect Credentials " , HttpStatus.UNAUTHORIZED);
     }
 }
 
 @GetMapping("/view")
 public ResponseEntity<List<Customer>> AllCustomer() {
	 List<Customer> Custall= custServ.allCustomer();
	 return new ResponseEntity<List<Customer>>(Custall, HttpStatus.OK);
 }
 
 
 
}
