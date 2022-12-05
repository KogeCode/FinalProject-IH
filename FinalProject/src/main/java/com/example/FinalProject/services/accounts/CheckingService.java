package com.example.FinalProject.services.accounts;

import com.example.FinalProject.dtos.accounts.UpdateCheckingDTO;
import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.accounts.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AccountRepository accountRepository;

    //Service para agregar una nueva cuenta Checking
    public Checking addChecking(Checking checking) {
        return checkingRepository.save(checking);
    }
}


