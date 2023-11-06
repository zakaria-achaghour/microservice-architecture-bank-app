package com.zakaria.account.service.services;


import com.zakaria.account.service.dtos.AccountRequestDto;
import com.zakaria.account.service.dtos.AccountResponseDto;
import com.zakaria.account.service.exceptions.AccountNotFoundException;

import java.util.List;

public interface AccountService {

    AccountResponseDto save(AccountRequestDto request);
    List<AccountResponseDto> listAccounts();
    AccountResponseDto getAccountById(String id) throws AccountNotFoundException;
    AccountResponseDto update(AccountRequestDto requestDTO, String id) throws AccountNotFoundException;
    void deleteAccount(String id) throws AccountNotFoundException;
}
