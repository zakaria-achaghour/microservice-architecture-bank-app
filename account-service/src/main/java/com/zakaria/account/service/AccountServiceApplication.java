package com.zakaria.account.service;

import com.zakaria.account.service.entities.Account;
import com.zakaria.account.service.enums.AccountType;
import com.zakaria.account.service.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    // @Bean
    CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Account account = new Account()
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .balance(100 + Math.random() * 500)
                        .accountType(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT :AccountType.SAVING_ACCOUNT)
                        .currency("MAD")
                        .createdAt(new Date())
                        .build();
                accountRepository.save(account);
            }
        };
    }
}
