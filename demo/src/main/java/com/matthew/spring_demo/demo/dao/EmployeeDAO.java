package com.matthew.spring_demo.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matthew.spring_demo.demo.entity.Employee;

@Transactional
@Repository
public class EmployeeDAO implements EmployeeDAOInterface{
    @PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Employees available in database and return it as List<Employee>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		
		String hql = "FROM employees as emp ORDER BY emp.emp_no";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Employee detail by given Employee id 
	 */
	@Override
	public Employee getEmployee(int EmployeeId) {
		
		return entityManager.find(Employee.class, EmployeeId);
	}

	/**
	 * This method is responsible to create new Employee in database
	 */
	@Override
	public Employee createEmployee(Employee Employee) {
		entityManager.persist(Employee);
		Employee b = getLastInsertedEmployee();
		return b;
	}

	/**
	 * This method is responsible to update Employee detail in database
	 */
	@Override
	public Employee updateEmployee(int EmployeeId, Employee Employee) {
		
		//First We are taking Employee detail from database by given Employee id and 
		// then updating detail with provided Employee object
		Employee EmployeeFromDB = getEmployee(EmployeeId);
        EmployeeFromDB.setEmpNo(Employee.getEmpNo());
        EmployeeFromDB.setBirthday(Employee.getBirthday());
        EmployeeFromDB.setFirstName(Employee.getFisrtName());
        EmployeeFromDB.setLastName(Employee.getLastName());
        EmployeeFromDB.setGender(Employee.getGender());
        EmployeeFromDB.setHireDate(Employee.getHireDate());
	
		
		entityManager.flush();
		
		//again i am taking updated result of Employee and returning the Employee object
		Employee updatedEmployee = getEmployee(EmployeeId);
		
		return updatedEmployee;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteEmployee(int empNum) {
		Employee Employee = getEmployee(empNum);
		entityManager.remove(Employee);
		
		//we are checking here that whether entityManager contains earlier deleted Employee or not
		// if contains then Employee is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Employee);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Employee class
	 * @return Employee
	 */
	private Employee getLastInsertedEmployee(){
		String hql = "from employees order by emp_no DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Employee Employee = (Employee)query.getSingleResult();
		return Employee;
	}

}