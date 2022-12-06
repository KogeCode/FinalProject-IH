package com.example.FinalProject.repositories.accounts;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.account.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckingRepository extends JpaRepository<Checking,Long> {
    //List<Checking> findByStatusCheckingAccount (Status status);
    //Checking addNewChecking (Checking checking);
}
