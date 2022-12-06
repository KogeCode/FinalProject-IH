package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.services.accounts.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SavingAccountController {
    @Autowired
    SavingAccountService savingAccountService;

    void addSavingAccount (SavingAccount savingAccount){

    }
}
