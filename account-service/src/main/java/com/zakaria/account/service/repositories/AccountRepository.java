package com.zakaria.account.service.repositories;


import com.zakaria.account.service.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, String> {
}
