package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.account.StudentChecking;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.accounts.CheckingRepository;
import com.example.FinalProject.repositories.accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
   StudentCheckingRepository studentCheckingRepository;

    public Account addNewChecking(Checking checking) {
       if(Period.between(checking.getPrimaryOwner().getDateOfBirth(), LocalDate.now()).getYears()<24){

           StudentChecking studentChecking = new StudentChecking(checking.getBalance(), checking.getPrimaryOwner(), checking.getSecundaryOwner(), checking.getSecretKey(), checking.getCreationDate(), checking.getStatus());
           return studentCheckingRepository.save(studentChecking);
       }else{
           return  checkingRepository.save(checking);
       }

    }


    public void  deleteChecking(Long id) {
        Checking checking = checkingRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID del AccountHolder no está registrado en la base de datos"));
      checkingRepository.deleteById(checking.getAccountId());
    }
}


