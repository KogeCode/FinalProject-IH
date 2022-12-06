package com.example.FinalProject.repositories.accounts;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.account.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long> {

}
