package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class CourierSecurity {
	@Autowired
	SecurityConfig securityConfig;
	@Bean
	UserDetailsService userDetailsService() {
		return securityConfig;
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((request) -> request
				.requestMatchers("/courier/delete/**", "/courier/update/**","/courier/addCourier").hasRole("USER")
				.requestMatchers("/courier/Courier", "/h2-console/**").hasRole("ADMIN")
				.requestMatchers("/users/login/**").permitAll()
				.anyRequest().authenticated()
				).headers((header)->header.frameOptions(frame->frame.disable()))
				.formLogin((form)->form.loginPage("http://localhost:4200/login")
						.defaultSuccessUrl("http://localhost:4200/home", true)
						.permitAll())
				.build();
	}
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider  provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(securityConfig);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
