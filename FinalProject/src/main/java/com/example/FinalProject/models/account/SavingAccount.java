package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
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

    public SavingAccount(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, Double interest, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee);
        this.interest = interest;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
    }

    public SavingAccount(BigDecimal balance, String primaryOwner, Double penalthyFee, Double interest, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, penalthyFee);
        this.interest = interest;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status=Status.ACTIVE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
