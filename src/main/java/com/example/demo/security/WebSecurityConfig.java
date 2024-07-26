package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private UserDetailsService userDetailService;
	
	private PasswordEncoder passwordEncoder;
	
	public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailService = userDetailsService;
		this.passwordEncoder = getPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		//TODO: Implement real authentification for all users
		return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests.anyRequest().permitAll())
                .userDetailsService(userDetailService)
                .build();
	}
	
	private static PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
