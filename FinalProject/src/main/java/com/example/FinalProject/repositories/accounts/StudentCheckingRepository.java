package com.example.FinalProject.repositories.accounts;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.account.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCheckingRepository extends JpaRepository <StudentChecking,Long> {

}
