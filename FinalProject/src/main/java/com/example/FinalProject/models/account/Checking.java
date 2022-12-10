package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DynamicUpdate
public class Checking extends Account {

    private Double monthlyMaintenanceFee = 12.0;
    private String secretKey;
    private LocalDate creationDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private BigDecimal minimumBalance;


    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secundaryOwner, String secretKey, LocalDate creationDate, Status status, BigDecimal minimumBalance) {
        super(balance, primaryOwner, secundaryOwner);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
        this.minimumBalance = minimumBalance;
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, String secretKey, LocalDate creationDate, Status status, BigDecimal minimumBalance) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
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
            throw new ResponseStatusException(HttpStatus.CONFLICT, "the minimumBalance tiene que ser mas grande que 250");
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

    public void penalthyFeeApply (){
        if(super.getBalance().compareTo(minimumBalance)<0){
            super.setBalance(super.getBalance().subtract(getPENALTHY_FEE()));
        }
    }
}
