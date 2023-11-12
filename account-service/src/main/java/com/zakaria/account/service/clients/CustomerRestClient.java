package com.zakaria.account.service.clients;

import com.zakaria.account.service.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable  Long id);

    @GetMapping("/api/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    List<Customer> findCustomers();

    default Customer getDefaultCustomer(Long  id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Unknown");
        customer.setEmail("Unknown");
        return customer;
    }
    default List<Customer> getDefaultCustomers(Exception e ){
        return List.of();
    }
}
