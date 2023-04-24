package com.example.security;

import com.example.security.domain.Role;
import com.example.security.domain.User;
import com.example.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_VIEWER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "admin", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "user1", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "user2", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "viewer1", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "super_admin", "password", new ArrayList<>()));

			userService.assignRoleToUser("admin", "ROLE_ADMIN");
			userService.assignRoleToUser("user1", "ROLE_USER");
			userService.assignRoleToUser("user1", "ROLE_VIEWER");
			userService.assignRoleToUser("user2", "ROLE_USER");
			userService.assignRoleToUser("viewer1", "ROLE_VIEWER");
			userService.assignRoleToUser("super_admin", "ROLE_SUPER_ADMIN");
		};
	}
}
