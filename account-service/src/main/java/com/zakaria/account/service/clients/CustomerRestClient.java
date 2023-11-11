package com.zakaria.account.service.clients;

import com.zakaria.account.service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    Customer findCustomerById(@PathVariable  Long id);

    @GetMapping("/api/customers")
    List<Customer> findCustomers();
}
