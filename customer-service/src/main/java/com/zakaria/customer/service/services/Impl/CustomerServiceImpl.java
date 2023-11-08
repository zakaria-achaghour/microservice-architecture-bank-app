package com.zakaria.customer.service.services.Impl;

import com.zakaria.customer.service.dtos.CustomerRequestDto;
import com.zakaria.customer.service.dtos.CustomerResponseDto;
import com.zakaria.customer.service.entities.Customer;
import com.zakaria.customer.service.exceptions.CustomerNotFoundException;
import com.zakaria.customer.service.mappers.CustomerMapper;
import com.zakaria.customer.service.repositories.CustomerRepository;
import com.zakaria.customer.service.services.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDto save(CustomerRequestDto request) {
        Customer customer = customerMapper.toEntity(request);
        customer.setCreatedAt(new Date());
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer==null) throw new CustomerNotFoundException(String.format("Custoemr Not Found with id :%s",id));
        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto requestDTO, Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer==null) throw new CustomerNotFoundException(String.format("Customer Not Found with id :%s", id));
        if(requestDTO.getName() != null) customer.setName(requestDTO.getName());
        if(requestDTO.getEmail() != null) customer.setEmail(requestDTO.getEmail());
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer==null) throw new CustomerNotFoundException(String.format("Customer Not Found with id :%s",id));
        customerRepository.deleteById(id);
    }
}
