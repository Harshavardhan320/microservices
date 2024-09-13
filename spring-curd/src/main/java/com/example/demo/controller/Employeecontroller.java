package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employees;
import com.example.demo.service.Employeeservice;

@RestController
public class Employeecontroller {
	@Autowired
	Employeeservice employeeservice;
	@PostMapping(value="/insertemployee")
	
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to employe data";
	}
	public Employees insert(@RequestBody Employees emp){
		 
		return this.employeeservice.addemployee(emp);
		
	}
	
	@PutMapping(value="/Updateemployee/{empid}/{salary}")
	
	public Employees Update(@PathVariable long empid, @PathVariable double salary) {
		return this.employeeservice.Updateemployee(empid,salary);
		
	}
			
	@DeleteMapping(value="/Deleteemployee/{empid}")
	public void Delete(@PathVariable long empid) {
		this.employeeservice.delete(empid);
	}
}
