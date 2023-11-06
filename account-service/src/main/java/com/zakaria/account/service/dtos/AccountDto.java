package com.zakaria.account.service.dtos;

import com.zakaria.account.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotNull
    private double balance;
    @NotEmpty
    private String currency;
    @NotEmpty
    private AccountType accountType;
}