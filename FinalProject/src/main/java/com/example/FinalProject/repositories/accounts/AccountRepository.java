package com.example.FinalProject.repositories.accounts;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
