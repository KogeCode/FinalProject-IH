package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.services.accounts.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checking-accounts")
public class CheckingController {
    @Autowired
    CheckingService checkingService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addNewChecking(@RequestBody Checking checking) {
        return checkingService.addNewChecking(checking);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChecking (@PathVariable Long id){
        checkingService.deleteChecking(id);
    }
}
