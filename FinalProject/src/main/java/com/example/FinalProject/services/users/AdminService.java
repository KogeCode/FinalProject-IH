package com.example.FinalProject.services.users;


import com.example.FinalProject.repositories.accounts.CheckingRepository;
import com.example.FinalProject.repositories.accounts.CreditCardRepository;
import com.example.FinalProject.repositories.accounts.SavingAccountRepository;
import com.example.FinalProject.repositories.accounts.StudentCheckingRepository;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    SavingAccountRepository savingAccountRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;


    //metodo para crear cuentas (checking, saving, creditcard)

    //metodo para eliminar cuentas

    //metodo para obtener todas las cuentas


}
