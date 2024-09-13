package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Courier;
import com.example.demo.services.Courierservices;

@RestController
@CrossOrigin
@RequestMapping(value="/courier")
public class CourierController {

	
	@Autowired
	Courierservices courierService;
	
	@PostMapping(value="/addCourier") //alluser
	public Courier addcourier(@RequestBody Courier courier) {

		return this.courierService.addCourier(courier);
	}
	
	@GetMapping(value="/Courier") //admin
	public List<Courier>  allCourier() {
		
		return this.courierService.getAllCourier();
	}
	
	@PutMapping(value="/update/{id}") //admin, users
	public Courier updateCourier(@RequestBody Courier courier, @PathVariable long id) {
		return this.courierService.updateCourier(courier, id);
	}
	
	@DeleteMapping(value="/delete/{id}")//admin, users
	public void deleteCourier(@PathVariable long id) {
		this.courierService.deleteCourier(id);
	}
}
