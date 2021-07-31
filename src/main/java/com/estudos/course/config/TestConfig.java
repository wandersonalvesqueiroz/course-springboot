package com.estudos.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudos.course.entities.User;
import com.estudos.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jose", "jose@gmail.com", "888888", "54321");
		User u2 = new User(null, "Manuel", "manuel@gmail.com", "777777", "98765");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
