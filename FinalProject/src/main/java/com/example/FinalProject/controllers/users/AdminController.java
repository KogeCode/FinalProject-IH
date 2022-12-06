package com.example.FinalProject.controllers.users;

import com.example.FinalProject.models.users.Admin;
import com.example.FinalProject.services.users.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //PostMethod to add an admin account to database
    @PostMapping("/add-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addNewAdmin (@RequestBody Admin admin) {
        return adminService.addNewAdmin(admin);
    }
}
