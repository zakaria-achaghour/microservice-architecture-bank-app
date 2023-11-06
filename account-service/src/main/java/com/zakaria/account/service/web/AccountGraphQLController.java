package com.zakaria.account.service.web;

import com.zakaria.account.service.dtos.AccountRequestDto;
import com.zakaria.account.service.dtos.AccountResponseDto;
import com.zakaria.account.service.entities.Account;
import com.zakaria.account.service.exceptions.AccountNotFoundException;
import com.zakaria.account.service.repositories.AccountRepository;
import com.zakaria.account.service.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@AllArgsConstructor
public class AccountGraphQLController {

    private AccountRepository accountRepository;
    private AccountService accountService;

    @QueryMapping
    public List<Account> accounts() {
        return this.accountRepository.findAll();
    }

    @QueryMapping
    public Account accountById(@Argument String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public AccountResponseDto addAccount(@Argument AccountRequestDto accountDto) {
        return accountService.save(accountDto);
    }

    @MutationMapping
    public AccountResponseDto updateAccount(@Argument AccountRequestDto accountDto, @Argument String id) throws AccountNotFoundException {
        return accountService.update(accountDto, id);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) throws AccountNotFoundException {
       accountService.deleteAccount(id);
       return true;
    }
}
