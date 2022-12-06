package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.CreditCard;
import com.example.FinalProject.services.accounts.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    void addCreditCard (CreditCard creditCard){

    }
}
