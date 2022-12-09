package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("account-holder")
public class AccountController {
    @Autowired
    AccountHolderService accountHolderService;

    @GetMapping("/get-balance/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BigDecimal getBalanceAccountHolder(@PathVariable Long id, @RequestParam String secretKey){
        return accountHolderService.getBalanceAccountHolder(id,secretKey);
    }
}
