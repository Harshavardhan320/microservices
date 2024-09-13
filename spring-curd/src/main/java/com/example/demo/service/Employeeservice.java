package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employees;
import com.example.demo.repository.EmployeeRepository;

@Service
public class Employeeservice {
@Autowired
	EmployeeRepository employeerepository;
	

  public Employees addemployee(Employees emp) {
	  
	return employeerepository.save(emp);
	
	
  }
  public Employees Updateemployee(Long empid,double employeesalary) {
	  
	  Optional<Employees> employee = employeerepository.findById(empid);
	  
	  
	 Employees employe= employee.get();
	 
	 employe.setSalary(employeesalary);
	 
	 return employeerepository.save(employe);
	 
	
	  
  }
	  
  
  public void delete( long empid) {
	  
	  employeerepository.deleteById(empid);
	  
  }
		
  
  
  
	
}
