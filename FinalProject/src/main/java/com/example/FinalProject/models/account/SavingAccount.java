package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
@DynamicUpdate
public class SavingAccount extends Account {

    private Double interest; // 0.0025 - 0.5
    private String secretKey;
    private LocalDate creationDate =  LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal minimumBalance;

    private LocalDate lastApplyInterest = LocalDate.now();

    public SavingAccount() {
    }

    public SavingAccount(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secundaryOwner, Double interest, String secretKey, LocalDate creationDate, Status status, BigDecimal minimumBalance, LocalDate lastApplyInterest) {
        super(balance, primaryOwner, secundaryOwner);
        this.interest = interest;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
        this.minimumBalance = minimumBalance;
        this.lastApplyInterest = lastApplyInterest;
    }

    public SavingAccount(BigDecimal balance, AccountHolder primaryOwner, Double interest, String secretKey, LocalDate creationDate, Status status, BigDecimal minimumBalance, LocalDate lastApplyInterest) {
        super(balance, primaryOwner);
        this.interest = interest;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = Status.ACTIVE;
        this.minimumBalance = minimumBalance;
        this.lastApplyInterest = lastApplyInterest;
    }

    public Double getInterest() {
        return interest;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        BigDecimal defaultValor = BigDecimal.valueOf(1000);
        BigDecimal minValor = BigDecimal.valueOf(100);


        if (minimumBalance == null) {
            this.minimumBalance = defaultValor;
        } else if (minimumBalance.compareTo(minValor) < 0) {
            this.minimumBalance = defaultValor;
        } else {
            this.minimumBalance = minimumBalance;
        }
    }

    public LocalDate getLastApplyInterest() {
        return lastApplyInterest;
    }

    public void setLastApplyInterest(LocalDate lastApplyInterest) {
        this.lastApplyInterest = lastApplyInterest;
    }

    public void setInterest(Double interest) {
        double defaultInterest = 0.0025;
        if (interest == null) {
            this.interest = defaultInterest;
        } else if (interest > 0.5) {
            this.interest = 0.5;
        } else {
            this.interest = interest;
        }

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

    //Método para aplicar el applyInterest cada vez que checkeamos el balance de la cuenta, si ha pasado un año desde que
    //se aplicó el interés se volverá a aplicar
    public void applyInterest() {

        if (Period.between(lastApplyInterest, LocalDate.now()).getYears() > 1) {
            super.setBalance(super.getBalance().add(super.getBalance().multiply(BigDecimal.valueOf(interest))
                    .multiply(BigDecimal.valueOf((Period.between(lastApplyInterest, LocalDate.now()).getYears())))));

            //Actualizamos el lastInterest a fecha actual sin perder los años
            lastApplyInterest.plusYears(Period.between(lastApplyInterest, LocalDate.now()).getYears());
        }
    }

    //Metodo para aplicar el pentalthyFee una vez el balance de la cuenta
    public void penalthyFeeApply (){
        if(super.getBalance().compareTo(minimumBalance)<0){
            super.setBalance(super.getBalance().subtract(getPENALTHY_FEE()));
        }
    }
}
