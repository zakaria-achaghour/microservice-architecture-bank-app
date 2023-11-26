package com.zakaria.customer.service;

import com.zakaria.customer.service.entities.Customer;
import com.zakaria.customer.service.repositories.CustomerRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void CustomerRepository_savedAll_ReturnSavedCustomer(){
        // arrange
        Customer customer = Customer.builder()
                .id(Long.getLong("1"))
                .name("zakaria")
                .email("zakaria@email.com")
                .build();
        // act
        Customer savedCustomer = customerRepository.save(customer);

        //assert
        Assertions.assertThat(savedCustomer).isNotNull();

    }

    @Test
    public void CustomerRepository_GetAll_ReturnMoreThenOneCustomer() {
        Customer customer1 = Customer.builder()
                .id(Long.getLong("1"))
                .name("zakaria")
                .email("zakaria@email.com")
                .build();
        Customer customer2 = Customer.builder()
                .id(Long.getLong("2"))
                .name("zakaria 2")
                .email("zakaria2@email.com")
                .build();
        Customer savedCustomer1 = customerRepository.save(customer1);
        Customer savedCustomer2 = customerRepository.save(customer2);

        List<Customer> list = customerRepository.findAll();

        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
    @Test
    public void CustomerRepository_FindById_ReturnCustomer() {
        Customer customer1 = Customer.builder()
                .id(Long.getLong("1"))
                .name("zakaria")
                .email("zakaria@email.com")
                .build();

        customerRepository.save(customer1);

        Customer customerList = customerRepository.findById(customer1.getId()).get();

        Assertions.assertThat(customerList).isNotNull();
    }

    @Test
    public void CustomerRepository_UpdateCustomer_ReturnCustomerNotNull() {
        Customer customer1 = Customer.builder()
                .id(Long.getLong("1"))
                .name("zakaria")
                .email("zakaria@email.com")
                .build();

        customerRepository.save(customer1);

        Customer customerSave = customerRepository.findById(customer1.getId()).get();
        customerSave.setName("Zakaria Ed");
        customerSave.setEmail("zakrariaEd@email.com");

        Customer updatedCustomer = customerRepository.save(customerSave);

        Assertions.assertThat(updatedCustomer.getName()).isNotNull();
        Assertions.assertThat(updatedCustomer.getEmail()).isNotNull();
    }

    @Test
    public void CustomerRepository_CustomerDelete_ReturnCustomerIsEmpty() {
        Customer customer1 = Customer.builder()
                .id(Long.getLong("1"))
                .name("zakaria")
                .email("zakaria@email.com")
                .build();

        customerRepository.save(customer1);

        customerRepository.deleteById(customer1.getId());
        Optional<Customer> customerReturn = customerRepository.findById(customer1.getId());

        Assertions.assertThat(customerReturn).isEmpty();
    }
}
