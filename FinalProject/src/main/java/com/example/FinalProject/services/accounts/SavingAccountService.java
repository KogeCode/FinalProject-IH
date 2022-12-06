package com.example.FinalProject.services.accounts;

import com.example.FinalProject.repositories.accounts.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingAccountService {
    @Autowired
    SavingAccountRepository savingAccountRepository;
}
