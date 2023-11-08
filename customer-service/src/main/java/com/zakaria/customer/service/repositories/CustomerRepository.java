package com.zakaria.customer.service.repositories;

import com.zakaria.customer.service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
