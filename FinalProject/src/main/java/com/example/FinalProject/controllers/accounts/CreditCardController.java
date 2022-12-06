package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.CreditCard;
import com.example.FinalProject.services.accounts.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditcard-accounts")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard addNewCreditCard (@RequestBody CreditCard creditCard){
       return creditCardService.addNewCreditCard(creditCard);

    }
}
