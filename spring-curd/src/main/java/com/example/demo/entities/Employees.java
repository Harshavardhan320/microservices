package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
 
@Entity
@Table(name="Employees")
public class Employees {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long employeeid;
	   
	
	private String employeename;
	
	
	private double salary;
	
}
