package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class SavingAccount extends Account{
    private Double interest;
    private String secretKey;
    private LocalDate creationDate;
    @Enumerated (EnumType.STRING)
    private Status status;

    public SavingAccount() {
    }

    public SavingAccount(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, AccountHolder accountHolder, AccountHolder accountHolderSecundary, Double interest, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee, accountHolder, accountHolderSecundary);
        this.interest = interest;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
    }

    public SavingAccount(BigDecimal balance, String primaryOwner, Double penalthyFee, AccountHolder accountHolder, Double interest, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, penalthyFee, accountHolder);
        this.interest = interest;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
