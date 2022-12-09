package com.example.FinalProject.services.users;


import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.CreditCard;
import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.models.users.Admin;
import com.example.FinalProject.models.users.Role;
import com.example.FinalProject.repositories.accounts.*;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.AdminRepository;
import com.example.FinalProject.repositories.users.RoleRepository;
import com.example.FinalProject.repositories.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class AdminService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AccountRepository accountRepository;
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

    public Admin addNewAdmin(Admin admin) {
        Admin admin1 = adminRepository.save(admin);
        roleRepository.save(new Role("ADMIN", admin));
        return admin;
    }

    public BigDecimal accessBalance(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist"));
        return account.getBalance();
    }

    public BigDecimal getAccountBalance( Long idAccount) {

        Account account = accountRepository.findById(idAccount).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID de la cuenta no está registrado en la base de datos"));


        if (account instanceof CreditCard) {
            ((CreditCard) account).applyInterestCreditCard();
        } else if (account instanceof SavingAccount) {
            ((SavingAccount) account).applyInterest();
        }

        return account.getBalance();

    }




    //metodo para eliminar cuentas

    //metodo para obtener todas las cuentas


}
