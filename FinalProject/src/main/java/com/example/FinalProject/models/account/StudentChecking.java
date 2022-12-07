package com.example.FinalProject.models.account;

import com.example.FinalProject.enums.Status;
import com.example.FinalProject.models.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DynamicUpdate
public class StudentChecking extends Account{
    @NotEmpty
    private String secretKey;
    @NotEmpty
    private LocalDate creationDate;
    @Enumerated (EnumType.STRING)
    @NotEmpty
    private Status status;

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, String secundaryOwner, AccountHolder accountHolder, AccountHolder accountHolderSecundary, String secretKey, LocalDate creationDate, Status status) {
        super(balance, primaryOwner, secundaryOwner, accountHolder, accountHolderSecundary);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.status = status;
    }

    public StudentChecking(BigDecimal balance, String primaryOwner, AccountHolder accountHolder, String secretKey, LocalDate creationDate, Status status) {
        super(balance, primaryOwner, accountHolder);
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
