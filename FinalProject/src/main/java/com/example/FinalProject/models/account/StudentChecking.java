package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
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

    public StudentChecking(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, String secretKey, LocalDate creationDate, Status status) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, Double penalthyFee, String secretKey, LocalDate creationDate, Status status) {
        super(balance, primaryOwner, penalthyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
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
