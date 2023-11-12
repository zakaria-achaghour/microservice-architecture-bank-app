package com.zakaria.account.service.services.Impl;

import com.zakaria.account.service.clients.CustomerRestClient;
import com.zakaria.account.service.dtos.AccountRequestDto;
import com.zakaria.account.service.dtos.AccountResponseDto;
import com.zakaria.account.service.entities.Account;
import com.zakaria.account.service.exceptions.AccountNotFoundException;
import com.zakaria.account.service.mappers.AccountMapper;
import com.zakaria.account.service.model.Customer;
import com.zakaria.account.service.repositories.AccountRepository;
import com.zakaria.account.service.services.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service @Transactional
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;
    private AccountMapper accountMapper;
    @Override
    public AccountResponseDto save(AccountRequestDto request) {
        Account account = accountMapper.toEntity(request);
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(new Date());
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public List<AccountResponseDto> listAccounts() {
        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(account -> {
            account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });
        return accounts.stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AccountResponseDto getAccountById(String id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        if (account==null) throw new AccountNotFoundException(String.format("Account Not Found with id :%s",id));
        return accountMapper.toDto(account);
    }

    @Override
    public AccountResponseDto update(AccountRequestDto requestDTO, String id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account==null) throw new AccountNotFoundException(String.format("Account Not Found with id :%s", id));
        account.setBalance(requestDTO.getBalance());
        if(requestDTO.getCurrency() != null) account.setCurrency(requestDTO.getCurrency());
        if(requestDTO.getAccountType() != null) account.setAccountType(requestDTO.getAccountType());
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDto(savedAccount);
    }

    @Override
    public void deleteAccount(String id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account==null) throw new AccountNotFoundException(String.format("Account Not Found with id :%s",id));
        accountRepository.deleteById(id);
    }
}
