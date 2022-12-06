package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.services.accounts.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCheckingController {
    @Autowired
    StudentCheckingService studentCheckingService;

    void addStudentCheckingController(){

    }
}
