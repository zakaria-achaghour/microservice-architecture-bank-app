package com.zakaria.customer.service;


import com.zakaria.customer.service.dtos.CustomerRequestDto;
import com.zakaria.customer.service.dtos.CustomerResponseDto;
import com.zakaria.customer.service.entities.Customer;
import com.zakaria.customer.service.mappers.CustomerMapper;
import com.zakaria.customer.service.repositories.CustomerRepository;
import com.zakaria.customer.service.services.Impl.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerMapper customerMapper;
    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    public void CustomerService_CreateCustomer_ReturnCustomerResponseDto() {
        CustomerRequestDto customerRequestDto = CustomerRequestDto.builder()
                .name("zakaria")
                .email("zakaria@email.com")
                .build();

        Customer expectedCustomer = new Customer();
        expectedCustomer.setId(1L); // Set an appropriate ID
        expectedCustomer.setName(customerRequestDto.getName());
        expectedCustomer.setEmail(customerRequestDto.getEmail());
        expectedCustomer.setCreatedAt(new Date()); // Set the creation dat

        // Mock the behavior of the CustomerMapper
        when(customerMapper.toEntity(customerRequestDto)).thenReturn(expectedCustomer);
        when(customerMapper.toDto(expectedCustomer)).thenReturn(new CustomerResponseDto());

        // Use doReturn for methods that return a value
        // doReturn(new CustomerResponseDto()).when(customerMapper).toDto(expectedCustomer);

        // Act
        // CustomerResponseDto customerResponseDto = customerService.save(customerRequestDto);

        // Assert
        // Add assertions based on the actual behavior of your mapping logic and response DTO

        // Example assertion (adjust based on your actual mapping logic):
         // Assertions.assertThat(customerResponseDto.getName()).isEqualTo(expectedCustomer.getName());
         // Assertions.assertThat(customerResponseDto.getEmail()).isEqualTo(expectedCustomer.getEmail());
         // Assertions.assertThat(customerResponseDto.getId()).isEqualTo(expectedCustomer.getId());

        // Verify that the save method was called with the expected arguments
        // verify(customerRepository, times(1)).save(expectedCustomer);
    }
}
