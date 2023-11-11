package com.zakaria.customer.service.services;

import com.zakaria.customer.service.dtos.CustomerRequestDto;
import com.zakaria.customer.service.dtos.CustomerResponseDto;
import com.zakaria.customer.service.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto save(CustomerRequestDto request);
    List<CustomerResponseDto> listCustomers();
    CustomerResponseDto getCustomerById(Long id) throws CustomerNotFoundException;
    CustomerResponseDto update(CustomerRequestDto requestDTO, Long id) throws CustomerNotFoundException;
    void deleteCustomer(Long id) throws CustomerNotFoundException;
}
