package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.services.accounts.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saving-accounts")
public class SavingAccountController {
    @Autowired
    SavingAccountService savingAccountService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingAccount addSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountService.addNewSavingAccount(savingAccount);

    }
}
