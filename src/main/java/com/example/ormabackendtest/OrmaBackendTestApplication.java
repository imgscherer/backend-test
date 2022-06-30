package com.example.ormabackendtest;

import com.example.ormabackendtest.entities.User;
import com.example.ormabackendtest.repositories.UserRepository;
import com.example.ormabackendtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OrmaBackendTestApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OrmaBackendTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Gabriel Scherer", "gabriel@gmail.com", "988888888", userService.tokenGenerator(), 1L);

		userRepository.saveAll(Arrays.asList(u1));
	}
}
