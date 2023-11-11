package com.zakaria.account.service.entities;

import com.zakaria.account.service.enums.AccountType;
import com.zakaria.account.service.model.Customer;
import jakarta.persistence.*;
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
    @Transient
    private Customer customer;
    private Long customerId;
}
