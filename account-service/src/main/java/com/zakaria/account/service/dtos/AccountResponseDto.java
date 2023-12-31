package com.zakaria.account.service.dtos;

import com.zakaria.account.service.enums.AccountType;
import com.zakaria.account.service.model.Customer;
import lombok.*;

import java.util.Date;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDto {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
    // private Long customerId;
    private Customer customer;
}
