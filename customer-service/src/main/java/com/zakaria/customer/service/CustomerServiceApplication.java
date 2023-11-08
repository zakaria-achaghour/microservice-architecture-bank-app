package com.zakaria.customer.service;

import com.zakaria.customer.service.entities.Customer;
import com.zakaria.customer.service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder().name("zakaria").email("zakaria@gmail.com").createdAt(new Date()).build(),
                    Customer.builder().name("aziz").email("aziz@gmail.com").createdAt(new Date()).build()
            );

            customerRepository.saveAll(customerList);
        };
    }
}
