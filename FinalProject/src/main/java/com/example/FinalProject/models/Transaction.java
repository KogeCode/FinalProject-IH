package com.example.FinalProject.models;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.users.AccountHolder;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private AccountHolder senderAccount;

    @ManyToOne
    @JoinColumn (name = "destination_account_id")
    private AccountHolder destinationAccount;

    private BigDecimal amount;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private final LocalDateTime transactionDate=LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(AccountHolder senderAccount, AccountHolder destinationAccount, BigDecimal amount) {
        this.senderAccount = senderAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public AccountHolder getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(AccountHolder senderAccount) {
        this.senderAccount = senderAccount;
    }

    public AccountHolder getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(AccountHolder destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
