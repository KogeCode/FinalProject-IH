package com.example.FinalProject.controllers.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.embedded.Address;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account-holder")
public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;


    @GetMapping("/get-accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAccountList(@PathVariable Long id){
        return accountHolderService.getAccountsList(id);
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addNewAccount (@RequestBody AccountHolder accountHolder){
        return accountHolderService.addNewAccount(accountHolder);
    }

    @PatchMapping("/update-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder updateAddress (@PathVariable Long id, @RequestBody Address address){
        return accountHolderService.updateAddress (id,address);
    }


    @GetMapping("/get-balance/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BigDecimal getBalanceAccountHolder(@PathVariable Long id, @RequestParam Long idAccount){
        return accountHolderService.getBalanceAccountHolder(id,idAccount);
    }
}
