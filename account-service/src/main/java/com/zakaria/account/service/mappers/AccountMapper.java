package com.zakaria.account.service.mappers;

import com.zakaria.account.service.dtos.AccountRequestDto;
import com.zakaria.account.service.dtos.AccountResponseDto;
import com.zakaria.account.service.entities.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    private ModelMapper modelMapper=new ModelMapper();
    public AccountResponseDto toDto(Account account){
        return modelMapper.map(account, AccountResponseDto.class);
    }
    public Account toEntity(AccountRequestDto accountDto){
        return modelMapper.map(accountDto,Account.class);
    }
}
