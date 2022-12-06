package com.example.FinalProject.controllers.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;


    @GetMapping("/get-accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAccountList(@PathVariable Long id){
        return accountHolderService.getAccountsList(id);
    }

}
