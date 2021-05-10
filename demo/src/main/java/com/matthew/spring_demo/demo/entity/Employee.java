package com.matthew.spring_demo.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //Set up all columns from the database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_no")
    private int emp_no;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "hire_date") 
    private LocalDate hireDate;

    //Getter and Setter Methods
    public int getEmpNo(){return this.emp_no;}
    public void setEmpNo(int num){ this.emp_no = num;}

    public LocalDate getBirthday(){return this.birthDate;}
    public void setBirthday(LocalDate newDate){ this.birthDate = newDate;}

    public String getFisrtName(){return this.firstName;}
    public void setFirstName(String name){ this.firstName = name;}

    public String getLastName(){return this.lastName;}
    public void setLastName(String name){ this.lastName = name;}

    public String getGender(){return this.gender;}
    public void setGender(String gen){ this.gender = gen;}

    public LocalDate getHireDate(){return this.hireDate;}
    public void setHireDate(LocalDate newDate){ this.hireDate = newDate;}

   

    
}
