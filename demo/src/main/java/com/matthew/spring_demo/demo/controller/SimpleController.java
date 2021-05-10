package com.matthew.spring_demo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.spring_demo.demo.entity.Employee;
import com.matthew.spring_demo.demo.services.EmployeeServiceInterface;



@Controller
@RequestMapping("employeeservice")
public class SimpleController {
    
    @Autowired
	private EmployeeServiceInterface service;
	
	@GetMapping("Employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		
		List<Employee> Employees = service.getEmployees();
		return new ResponseEntity<List<Employee>>(Employees, HttpStatus.OK);
		
	}
	
	@GetMapping("Employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
		Employee Employee = service.getEmployee(id);
		return new ResponseEntity<Employee>(Employee, HttpStatus.OK);
	}
	
	@PostMapping("Employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee){
		Employee b = service.createEmployee(Employee);
		return new ResponseEntity<Employee>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee Employee){
		
		Employee b = service.updateEmployee(id, Employee);
		return new ResponseEntity<Employee>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		boolean isDeleted = service.deleteEmployee(id);
		if(isDeleted){
			String responseContent = "Employee has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Employee from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}