package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class StudentChecking extends Account{

    private String secretKey;
    private LocalDate creationDate;
    @Enumerated (EnumType.STRING)

    private Status status;

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, AccountHolder accountHolder, AccountHolder accountHolderSecundary, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee, accountHolder, accountHolderSecundary);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status=Status.ACTIVE;
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, Double penalthyFee, AccountHolder accountHolder, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, penalthyFee, accountHolder);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status=Status.ACTIVE;
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
