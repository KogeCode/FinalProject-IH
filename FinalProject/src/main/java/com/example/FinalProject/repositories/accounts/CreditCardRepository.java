package com.example.FinalProject.repositories.accounts;

import com.example.FinalProject.models.account.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository <CreditCard, Long> {
}
