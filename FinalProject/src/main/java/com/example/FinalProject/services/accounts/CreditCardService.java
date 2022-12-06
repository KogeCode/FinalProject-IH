package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.account.CreditCard;
import com.example.FinalProject.repositories.accounts.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCard addNewCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }
}
