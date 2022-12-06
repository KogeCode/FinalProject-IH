package com.example.FinalProject.services.accounts;

import com.example.FinalProject.models.account.StudentChecking;
import com.example.FinalProject.repositories.accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckingService {
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public StudentChecking addNewStudentChecking(StudentChecking studentChecking) {
        return studentCheckingRepository.save(studentChecking);
    }
}
