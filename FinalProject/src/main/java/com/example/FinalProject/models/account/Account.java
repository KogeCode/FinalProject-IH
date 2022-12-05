package com.example.FinalProject.models.account;

import jakarta.persistence.*;

@Entity
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    private Double balance;
    private String primaryOwner;
    private String secundaryOwner;
    private Double penalthyFee;


    public Account() {
    }

    public Account(Double balance, String primaryOwner, String secundaryOwner, Double penalthyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secundaryOwner = secundaryOwner;
        this.penalthyFee = penalthyFee;
    }

    public Account(Double balance, String primaryOwner, Double penalthyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.penalthyFee = penalthyFee;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getSecundaryOwner() {
        return secundaryOwner;
    }

    public void setSecundaryOwner(String secundaryOwner) {
        this.secundaryOwner = secundaryOwner;
    }

    public Double getPenalthyFee() {
        return penalthyFee;
    }

    public void setPenalthyFee(Double penalthyFee) {
        this.penalthyFee = penalthyFee;
    }
}
