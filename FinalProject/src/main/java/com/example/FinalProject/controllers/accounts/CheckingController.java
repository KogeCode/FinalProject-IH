package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.Checking;
import com.example.FinalProject.services.accounts.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts/checking")
public class CheckingController {
    @Autowired
    CheckingService checkingService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking addNewChecking(@RequestBody Checking checking) {
        return checkingService.addNewChecking(checking);
    }

    /** @PostMapping("/add-checking")
     @ResponseStatus (HttpStatus.ACCEPTED)
     public Checking addNewChecking(@RequestBody Checking checking){
     return checkingService.addChecking(checking);
     }*/


}
