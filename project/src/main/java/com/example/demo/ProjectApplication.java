package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepo;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner{

	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	PasswordEncoder encode; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		
		this.usersRepo.save(new Users("harsha", this.encode.encode("harsha"), "ADMIN"));
		this.usersRepo.save(new Users("harshavardhan", this.encode.encode("harshavardhan"), "USER"));


		
	}
}
