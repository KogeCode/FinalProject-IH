package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account{

    private Double monthlyMaintenanceFee;
    private String secretKey;
    private LocalDate creationDate;
    private Status status;

    public Checking() {
    }

    public Checking(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, AccountHolder accountHolder, AccountHolder accountHolderSecundary, Double monthlyMaintenanceFee, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee, accountHolder, accountHolderSecundary);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status=Status.ACTIVE;
    }

    public Checking(BigDecimal balance, String primaryOwner, Double penalthyFee, AccountHolder accountHolder, Double monthlyMaintenanceFee, String secretKey, LocalDate creationDate) {
        super(balance, primaryOwner, penalthyFee, accountHolder);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status=Status.ACTIVE;
    }

    public Double getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Double monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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
