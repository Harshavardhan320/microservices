package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Courier;
import com.example.demo.repository.CourierRepo;

@Service
public class Courierservices {
	
	
	@Autowired
	CourierRepo courierRepo;
	
	
	public Courier addCourier(Courier courier) {

		return this.courierRepo.save(courier);
	}
	
	public List<Courier> getAllCourier(){
		
		return this.courierRepo.findAll();
	}

	public Courier updateCourier(Courier courier, long id) {
		 
		Optional<Courier> courierObj = this.courierRepo.findById(id);
			
		Courier courier1 = courierObj.get();
		courier1.setSenderName(courier.getSenderName());
		courier1.setRecipientName(courier.getRecipientName());
		courier1.setDeliveryAddress(courier.getDeliveryAddress());
		courier1.setPickupAddress(courier.getPickupAddress());
		courier1.setWeight(courier.getWeight());
		
		
		if(courierObj.isPresent()) {
			return this.courierRepo.save(courier1);
		}else {
			throw new NullPointerException("not found"); 
		}
		
		
	}

	public void deleteCourier(long id) {
		this.courierRepo.deleteById(id);
	}
}
