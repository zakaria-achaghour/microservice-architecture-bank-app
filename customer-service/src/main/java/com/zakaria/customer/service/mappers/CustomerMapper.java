package com.zakaria.customer.service.mappers;


import com.zakaria.customer.service.dtos.CustomerRequestDto;
import com.zakaria.customer.service.dtos.CustomerResponseDto;
import com.zakaria.customer.service.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    private ModelMapper modelMapper=new ModelMapper();
    public CustomerResponseDto toDto(Customer customer){
        return modelMapper.map(customer, CustomerResponseDto.class);
    }
    public Customer toEntity(CustomerRequestDto customerDto){
        return modelMapper.map(customerDto,Customer.class);
    }
}
