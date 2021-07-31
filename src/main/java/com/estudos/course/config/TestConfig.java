package com.estudos.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudos.course.entities.Order;
import com.estudos.course.entities.User;
import com.estudos.course.repository.OrderRepository;
import com.estudos.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jose", "jose@gmail.com", "888888", "54321");
		User u2 = new User(null, "Manuel", "manuel@gmail.com", "777777", "98765");
		
		Order o1 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-06-21T20:03:01Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-06-22T21:33:00Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
