package com.example.FinalProject.services.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.embedded.Address;
import com.example.FinalProject.models.users.AccountHolder;
import com.example.FinalProject.models.users.Role;
import com.example.FinalProject.repositories.accounts.AccountRepository;
import com.example.FinalProject.repositories.users.AccountHolderRepository;
import com.example.FinalProject.repositories.users.RoleRepository;
import com.example.FinalProject.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountHolderService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    //Obtención de todas las cuentas filtradas por ID del Usuario AccountHolder
    public List<Account> getAccountsList (Long id){
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no registrado en la base de datos"));
        return accountHolder.getAccountList();
    }

    public AccountHolder addNewAccount(AccountHolder accountHolder) {
        AccountHolder accountHolder1 = accountHolderRepository.save(accountHolder);
        roleRepository.save(new Role("ACCOUNT_HOLDER",accountHolder1));
        return accountHolder1;
    }

    public AccountHolder updateAddress(Long id, Address address) {
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID del AccountHolder no está registrado en la base de datos"));
        accountHolder.setPrimaryAddress(address);
        return accountHolderRepository.save(accountHolder);
    }

    public void deleteAccountHolder(Long id) {
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID del AccountHolder no está registrado en la base de datos"));

        accountHolderRepository.deleteById(accountHolder.getUserId());
    }

    public BigDecimal getBalanceAccountHolder(Long id, String secretKey) {
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El ID del AccountHolder no está registrado en la base de datos"));
        if (accountHolder.getPassword().equals(secretKey)){
            return accountHolder.getAccountList()
        }
    }

    //Metodo para obtener el balance de las cuentas filtrado por ID

}
