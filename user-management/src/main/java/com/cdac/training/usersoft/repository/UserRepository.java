package com.cdac.training.usersoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.usersoft.model.User;

/**
*Author : ${user}
*Date :31-Dec-2024
*Time:12:16:43 pm
*/

public interface UserRepository extends JpaRepository<User,Long>{

	
	Optional<User> findByEmail(String email);
}
