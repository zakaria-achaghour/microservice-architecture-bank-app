package com.zakaria.customer.service.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {

    private String id;
    private String name;
    private String email;
    private Date createdAt;
}
