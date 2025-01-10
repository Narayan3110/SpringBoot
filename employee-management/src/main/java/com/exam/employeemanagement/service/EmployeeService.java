package com.exam.employeemanagement.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.employeemanagement.model.Employee;
import com.exam.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository ;

	public Employee add(Employee employee) {
		
		employee.setPassword(passwordEncode(employee.getPassword()));
		
		return employeeRepository.save(employee) ;
	}
	
	public String passwordEncode(String password) {
		
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public List<Employee> getEmp() {
		
		return employeeRepository.findAll();
	}

	public Boolean delete(Long id) {
		
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			employeeRepository.deleteById(id);
			return true ;
		}
		return false;
	}
	

	public Employee update(Long id, Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			Employee e = emp.get();
			e.setPassword(passwordEncode(employee.getPassword()));
			e.setDept(employee.getDept());
			return employeeRepository.save(e);
		}
		return null;
	}

	public Optional<Employee> getByDept(String dept) {
		
		return employeeRepository.findByDept(dept);
		
	}
	
	
}
