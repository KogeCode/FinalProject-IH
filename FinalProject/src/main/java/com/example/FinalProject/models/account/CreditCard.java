package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CreditCard extends Account{

   private Double creditCardLimit;
   private Double interestRate;

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, AccountHolder accountHolder, AccountHolder accountHolderSecundary, Double creditCardLimit, Double interestRate) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee, accountHolder, accountHolderSecundary);
        this.creditCardLimit = creditCardLimit;
        this.interestRate = interestRate;
    }

    public CreditCard(BigDecimal balance, String primaryOwner, Double penalthyFee, AccountHolder accountHolder, Double creditCardLimit, Double interestRate) {
        super(balance, primaryOwner, penalthyFee, accountHolder);
        this.creditCardLimit = creditCardLimit;
        this.interestRate = interestRate;
    }

    public Double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(Double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
