package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.users.AccountHolder;
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

    public Checking addNewChecking(Checking checking) {
        return checkingRepository.save(checking);
    }


    public void  deleteChecking(Long id) {
        Checking checking = checkingRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID del AccountHolder no está registrado en la base de datos"));

      checkingRepository.deleteById(checking.getAccountId());
    }
}


