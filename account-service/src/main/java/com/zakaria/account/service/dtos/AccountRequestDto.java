package com.zakaria.account.service.dtos;

import com.zakaria.account.service.enums.AccountType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequestDto {
    @NotNull
    private double balance;
    @NotEmpty
    private String currency;
    @NotEmpty
    private AccountType accountType;

    private Long customerId;
}
