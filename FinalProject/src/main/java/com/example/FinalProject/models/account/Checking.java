package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account {

    private Double monthlyMaintenanceFee = 12.0;
    private String secretKey;
    private LocalDate creationDate;
    private Status status;

    private BigDecimal minimumBalance;


    public Checking() {
    }

    public Checking(BigDecimal balance, String primaryOwner, String secundaryOwner, AccountHolder accountHolder, AccountHolder accountHolderSecundary, Double monthlyMaintenanceFee, String secretKey, LocalDate creationDate, Status status, BigDecimal minimumBalance) {
        super(balance, primaryOwner, secundaryOwner, accountHolder, accountHolderSecundary);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
        this.minimumBalance = minimumBalance;
    }

    public Checking(BigDecimal balance, String primaryOwner, AccountHolder accountHolder, Double monthlyMaintenanceFee, String secretKey, LocalDate creationDate, Status status, BigDecimal minimumBalance) {
        super(balance, primaryOwner, accountHolder);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {

        BigDecimal defaultValor = BigDecimal.valueOf(250);


        if (minimumBalance == null) {
            this.minimumBalance = defaultValor;
        } else if (minimumBalance.compareTo(defaultValor) < 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "the minimumBalance must be 12");
        } else {
            this.minimumBalance = minimumBalance;
        }
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
