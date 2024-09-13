package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepo;

@Service
public class SecurityConfig implements UserDetailsService  {

	@Autowired
	UsersRepo usersRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Users> users = this.usersRepo.findByUsername(username);
		
		if(users.isPresent()) {
			
			var user = users.get();
			
			return User.builder()
					.username(user.getUsername())
					.password(user.getPassword())
					.roles(getrole(user.getRoles()))
					.build();
		}else {
			
			throw new UsernameNotFoundException("user not found");
		}
	}
	
	private String getrole(String role) {
		if(role== null) { 
			return "USER";
		}else {
			return role;
		}
	}
	
}
