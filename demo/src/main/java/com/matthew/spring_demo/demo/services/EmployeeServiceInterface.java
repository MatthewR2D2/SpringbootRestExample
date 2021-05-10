package com.matthew.spring_demo.demo.services;

import java.util.List;
import com.matthew.spring_demo.demo.entity.Employee;

public interface EmployeeServiceInterface {

    List<Employee> getEmployees();
	Employee createEmployee(Employee emp);
	Employee updateEmployee(int empNum, Employee emp);
	Employee getEmployee(int empNum);
	boolean deleteEmployee(int empNum);
    
}
