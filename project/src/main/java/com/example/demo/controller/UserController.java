package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value="login/{username}/{password}")
	public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password){
		
		try {
			String role= this.userService.login(username, password);
			return new ResponseEntity<>(role, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
