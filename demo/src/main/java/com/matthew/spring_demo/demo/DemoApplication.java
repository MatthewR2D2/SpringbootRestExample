package com.matthew.spring_demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//To use this 
		//http://localhost:8085/employeeservice

		/**
		 * ### 7. To get list of Employees call following endpoint with GET Request
			```
			http://localhost:8085/employeeservice/Employees
			```
			### 8.To Create New Employees use following url with POST Request
			```
			http://localhost:8085/employeeservice/Employees
		 */
		SpringApplication.run(DemoApplication.class, args);
	}

}
