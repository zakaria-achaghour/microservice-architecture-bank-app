package com.zakaria.customer.service.dtos;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto {
    private String name;
    private String email;
}
