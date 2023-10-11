package com.example.MyPractice;

import com.example.MyPractice.customer.Customer;
import com.example.MyPractice.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args -> {
//			customers=new ArrayList<>();

			Customer naveen=new Customer(
					"Naveen",
					"naveen@gmail.com",
					22
			);
//			customers.add(naveen);

			Customer prajwal=new Customer(
					"Prajwal",
					"prajwal@gmail.com",
					23
			);
//			customers.add(prajwal);

			List<Customer> customers = List.of(naveen, prajwal);
			customerRepository.saveAll(customers);
		};
	}
}
