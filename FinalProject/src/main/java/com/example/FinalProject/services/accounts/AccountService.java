package com.example.FinalProject.services.accounts;

import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;

    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
