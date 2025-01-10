package com.exam.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.employeemanagement.model.Employee;
import com.exam.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService ;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		
		Employee emp = employeeService.add(employee);
		if(emp != null) {
			return new ResponseEntity<String>("Emplyee ", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Emplyee ", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> emp = employeeService.getEmp();
		
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  deleteEmployee(@PathVariable Long id){
		
		Boolean check = employeeService.delete(id);
		
		if(check) {
			return new ResponseEntity<String>("Deleted ", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error ", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id , @RequestBody Employee employee){
		Employee emp = employeeService.update(id , employee);
		if(emp != null ) {
			return new ResponseEntity<>(emp , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/dept/{dept}")
	public ResponseEntity<Optional<Employee>> getDept(@PathVariable String dept){
		Optional<Employee> emp = employeeService.getByDept(dept);
		
		return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
	}
}
