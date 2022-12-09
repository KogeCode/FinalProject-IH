package com.example.FinalProject.repositories.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long> {
    BigDecimal findByIdUser(Long id);
}
