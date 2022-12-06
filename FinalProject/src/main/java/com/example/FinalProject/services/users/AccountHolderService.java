package com.example.FinalProject.services.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AccountHolderService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    public List<Account> getAccountsList (Long id){
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no registrado en la base de datos"));
        return accountHolder.getAccountList();
    }
}
