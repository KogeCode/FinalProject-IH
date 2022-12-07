package com.example.FinalProject.controllers.accounts;

import com.example.FinalProject.models.account.StudentChecking;
import com.example.FinalProject.services.accounts.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student-accounts")
public class StudentCheckingController {
    @Autowired
    StudentCheckingService studentCheckingService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentChecking addStudentChecking (@RequestBody StudentChecking studentChecking){
       return studentCheckingService.addNewStudentChecking(studentChecking);
    }
}
