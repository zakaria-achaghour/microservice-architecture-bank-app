package com.zakaria.account.service.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Customer {
    private String name;
    private String email;
    private Date createdAt;
}
