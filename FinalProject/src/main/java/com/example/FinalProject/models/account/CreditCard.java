package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import jakarta.persistence.*;

@Entity
public class CreditCard extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creditcard_id", nullable = false)
    private Long creditCardId;
   private Double creditCardLimit;
   private Double interestRate;

    public CreditCard() {
    }

    public CreditCard(Double balance, String primaryOwner, String secundaryOwner, Double penalthyFee, Double creditCardLimit, Double interestRate) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee);
        this.creditCardLimit = creditCardLimit;
        this.interestRate = interestRate;
    }

    public CreditCard(Double balance, String primaryOwner, Double penalthyFee, Double creditCardLimit, Double interestRate) {
        super(balance, primaryOwner, penalthyFee);
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
