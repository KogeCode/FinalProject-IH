package com.example.FinalProject.models.account;

import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    private BigDecimal balance;
    private String primaryOwner;
    private String secundaryOwner;
    private Double penalthyFee;
    @ManyToOne
    private AccountHolder accountHolder;
    @ManyToOne
    private AccountHolder accountHolderSecundary;

    public Account() {
    }

    public Account(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, AccountHolder accountHolder, AccountHolder accountHolderSecundary) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secundaryOwner = secundaryOwner;
        this.penalthyFee = penalthyFee;
        this.accountHolder = accountHolder;
        this.accountHolderSecundary = accountHolderSecundary;
    }

    public Account(BigDecimal balance, String primaryOwner, String secundaryOwner, Double penalthyFee, AccountHolder accountHolder) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secundaryOwner = secundaryOwner;
        this.penalthyFee = penalthyFee;
        this.accountHolder = accountHolder;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountHolder getAccountHolderSecundary() {
        return accountHolderSecundary;
    }

    public void setAccountHolderSecundary(AccountHolder accountHolderSecundary) {
        this.accountHolderSecundary = accountHolderSecundary;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
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
