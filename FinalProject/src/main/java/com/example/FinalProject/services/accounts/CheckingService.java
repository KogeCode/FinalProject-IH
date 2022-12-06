package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.accounts.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AccountRepository accountRepository;

    public Checking addNewChecking(Checking checking) {
        return checkingRepository.save(checking);
    }

    //Service para agregar una nueva cuenta Checking
   /* public Checking addChecking(Checking checking) {
        return checkingRepository.save(checking);
    }*/
}


