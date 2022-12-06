package com.example.FinalProject.repositories.users;

import com.example.FinalProject.models.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<Account,Long> {
}
