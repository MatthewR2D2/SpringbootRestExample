package com.matthew.spring_demo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.spring_demo.demo.entity.Employee;
import com.matthew.spring_demo.demo.dao.EmployeeDAO;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
	private EmployeeDAO dao;

	@Override
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return dao.createEmployee(emp);
	}

	@Override
	public Employee updateEmployee(int empNum, Employee emp) {
		return dao.updateEmployee(empNum, emp);
	}

	@Override
	public Employee getEmployee(int empNum) {
		return dao.getEmployee(empNum);
	}

	@Override
	public boolean deleteEmployee(int empNum) {
		return dao.deleteEmployee(empNum);
	}
    
}
