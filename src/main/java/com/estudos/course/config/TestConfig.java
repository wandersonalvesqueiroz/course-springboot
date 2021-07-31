package com.estudos.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudos.course.entities.Category;
import com.estudos.course.entities.Order;
import com.estudos.course.entities.Product;
import com.estudos.course.entities.User;
import com.estudos.course.entities.enums.OrderStatus;
import com.estudos.course.repository.CategoryRepository;
import com.estudos.course.repository.OrderRepository;
import com.estudos.course.repository.ProductRepository;
import com.estudos.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product prod1 = new Product(null, "Livro XYZ", "Livro de criança", 40.50, "http://biblioteca1.com.br");
		Product prod2 = new Product(null, "Computador XYZ", "Computador de criança", 1000.00, "http://lojadopc1.com.br");
		Product prod3 = new Product(null, "Drone XYZ", "Drone", 3500.00, "http://eletronicos1.com.br");
		Product prod4 = new Product(null, "Livro XPTO", "Livro de auto ajuda", 150.99, "http://biblioteca1.com.br");
		Product prod5 = new Product(null, "Notebook XPTO", "Notebook de trabalho", 2149.99, "http://lojadopc2.com.br");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
                 
		User u1 = new User(null, "Jose", "jose@gmail.com", "888888", "54321");
		User u2 = new User(null, "Manuel", "manuel@gmail.com", "777777", "98765");
		
		Order o1 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-06-21T20:03:01Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-06-22T21:33:00Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
