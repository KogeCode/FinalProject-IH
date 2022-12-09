package com.example.FinalProject.models.account;

import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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
    @ManyToOne
    @NotNull
    @JoinColumn (name = "owner_account_id")
    private AccountHolder primaryOwner;
    @ManyToOne
    private AccountHolder secundaryOwner;
    private final BigDecimal PENALTHY_FEE = new BigDecimal(40);

    public Account() {
    }

    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secundaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secundaryOwner = secundaryOwner;
    }

    public Account(BigDecimal balance, AccountHolder primaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
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

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecundaryOwner() {
        return secundaryOwner;
    }

    public void setSecundaryOwner(AccountHolder secundaryOwner) {
        this.secundaryOwner = secundaryOwner;
    }

    public BigDecimal getPENALTHY_FEE() {
        return PENALTHY_FEE;
    }
}
