package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

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

    public void modifyAddBalance(Long id, BigDecimal amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no registrada en la base de datos"));

        account.setBalance(account.getBalance().add(amount));

        accountRepository.save(account);
    }

    public void modifySubstractBalance(Long id, BigDecimal amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no registrada en la base de datos"));
        account.setBalance(account.getBalance().subtract(amount));

       //Comprobamos si la cuenta es o del tipo Checking o del tipo Saving y aplicamos el penalthy fee en el caso de que se cumpla la condición

        if (account instanceof Checking) {
            ((Checking) account).penalthyFeeApply();
        } else if (account instanceof SavingAccount) {
            ((SavingAccount) account).penalthyFeeApply();
        }

        accountRepository.save(account);
    }
}
