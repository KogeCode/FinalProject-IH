package com.example.FinalProject.controllers.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.models.account.CreditCard;
import com.example.FinalProject.models.account.SavingAccount;
import com.example.FinalProject.models.users.Admin;
import com.example.FinalProject.services.accounts.AccountService;
import com.example.FinalProject.services.accounts.CheckingService;
import com.example.FinalProject.services.accounts.CreditCardService;
import com.example.FinalProject.services.accounts.SavingAccountService;
import com.example.FinalProject.services.users.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account-admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    CheckingService checkingService;
    @Autowired
    SavingAccountService savingAccountService;
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    AccountService accountService;

    //PostMethod to add an admin account to database
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addNewAdmin(@RequestBody Admin admin) {
        return adminService.addNewAdmin(admin);
    }

    //Rutas para que el Admin pueda crear CheckingAccount, SavingAccount y CreditCard
    @PostMapping("/add-checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addNewChecking(@RequestBody Checking checking) {
        return checkingService.addNewChecking(checking);
    }

    @PostMapping("/add-saving-account")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingAccount addSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountService.addNewSavingAccount(savingAccount);
    }

    @PostMapping("/add-credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard addNewCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.addNewCreditCard(creditCard);

    }

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getAccountBalance(@PathVariable Long idAccount) {
        return adminService.getAccountBalance(idAccount);
    }

    @DeleteMapping("/delete-account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }
    @DeleteMapping("/delete-user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        accountService.deleteUser(id);
    }

    //Metodo para modificar el balance de una cuenta
    @PatchMapping("/balance-add/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void modifyAddBalance (@PathVariable Long id, @RequestParam BigDecimal amount){
        accountService.modifyAddBalance(id,amount);
    }
    @PatchMapping("/balance-subtract/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void modifySubstractBalance (@PathVariable Long id, @RequestParam BigDecimal amount){
        accountService.modifySubstractBalance(id,amount);
    }
}
