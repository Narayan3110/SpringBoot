package com.cdac.training.usersoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.usersoft.model.User;
import com.cdac.training.usersoft.repository.UserRepository;

/**
*Author : ${user}
*Date :31-Dec-2024
*Time:12:19:49 pm
*/


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void registerUser(User user) {
		userRepository.save(user);   //calling the method of JPARepository
	}
	
	public Optional<User> loginUser(String email , String passwords){
		
		return userRepository.findByEmail(email).filter(user -> user.getPasswords().equals(passwords));
		
	}

}
