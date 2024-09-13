package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepo;

@Service
public class UserService {
	
	@Autowired
	private UsersRepo userRepo;
	
	@Autowired
	PasswordEncoder encode;
	
	public String  login(String username, String password) {
		
		Optional<Users> userObj = this.userRepo.findByUsername(username);
		
		Users user = userObj.get();
		
		password= this.encode.encode(password);
		
		if(user.getPassword() == password) {
			return user.getRoles();
		}else {
			throw new NullPointerException("invalid username and password");
		}
		
	}
}
