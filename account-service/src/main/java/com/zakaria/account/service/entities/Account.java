package com.zakaria.account.service.entities;

import com.zakaria.account.service.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity(name = "accounts")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Account {

    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
