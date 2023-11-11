package com.zakaria.account.service;

import com.zakaria.account.service.entities.Account;
import com.zakaria.account.service.enums.AccountType;
import com.zakaria.account.service.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    // @Bean
    CommandLineRunner start(AccountRepository accountRepository) {
        return args -> {
                Account account1 = new Account()
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .balance(5000)
                        .accountType(AccountType.CURRENT_ACCOUNT)
                        .currency("MAD")
                        .customerId(Long.valueOf(1))
                        .createdAt(new Date())
                        .build();

            Account account2 = new Account()
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .balance(90000)
                    .accountType(AccountType.SAVING_ACCOUNT)
                    .currency("MAD")
                    .customerId(Long.valueOf(1))
                    .createdAt(new Date())
                    .build();

            Account account3 = new Account()
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .balance(57890)
                    .accountType(AccountType.CURRENT_ACCOUNT)
                    .currency("MAD")
                    .customerId(Long.valueOf(2))
                    .createdAt(new Date())
                    .build();

            Account account4 = new Account()
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .balance(500)
                    .accountType(AccountType.CURRENT_ACCOUNT)
                    .currency("USD")
                    .customerId(Long.valueOf(3))
                    .createdAt(new Date())
                    .build();
            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);
            accountRepository.save(account4);
        };
    }
}
