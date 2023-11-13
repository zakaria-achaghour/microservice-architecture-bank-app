package com.zakaria.account.service.services;


import com.zakaria.account.service.dtos.AccountRequestDto;
import com.zakaria.account.service.dtos.AccountResponseDto;
import com.zakaria.account.service.exceptions.AccountNotFoundException;
import com.zakaria.account.service.exceptions.ResourceNotFoundException;

import java.util.List;

public interface AccountService {

    AccountResponseDto save(AccountRequestDto request);
    List<AccountResponseDto> listAccounts();
    AccountResponseDto getAccountById(String id) throws ResourceNotFoundException;
    AccountResponseDto update(AccountRequestDto requestDTO, String id) throws ResourceNotFoundException;
    void deleteAccount(String id) throws ResourceNotFoundException;
}
