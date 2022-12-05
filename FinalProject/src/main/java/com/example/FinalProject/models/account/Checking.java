package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.time.LocalDate;

@Entity
public class Checking extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checking_account_id", nullable = false)
    private Long checkingId;
    private Double monthlyMaintenanceFee;
    private String secretKey;
    private LocalDate creationDate;
    private Status status;

    public Checking() {
    }

    public Checking(Double balance, String primaryOwner, String secundaryOwner, Double penalthyFee, Double monthlyMaintenanceFee, String secretKey, LocalDate creationDate, Status status) {
        super(balance, primaryOwner, secundaryOwner, penalthyFee);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Checking(Double balance, String primaryOwner, Double penalthyFee, Double monthlyMaintenanceFee, String secretKey, LocalDate creationDate, Status status) {
        super(balance, primaryOwner, penalthyFee);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Long getCheckingId() {
        return checkingId;
    }

    public void setCheckingId(Long checkingId) {
        this.checkingId = checkingId;
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
