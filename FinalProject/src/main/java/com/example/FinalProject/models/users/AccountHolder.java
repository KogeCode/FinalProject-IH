package com.example.FinalProject.models.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.embedded.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
public class AccountHolder extends User {
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    @Embedded
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "physical_address")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "physical_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "physical_city")),
            @AttributeOverride(name = "country", column = @Column(name = "physical_country"))
    })
    private Address mailingAddress;

    @OneToMany(mappedBy = "primaryOwner", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Account> accountList = new ArrayList<>();
    @OneToMany(mappedBy = "secundaryOwner")
    @JsonIgnore
    private List<Account> accountListSecundaryOwner = new ArrayList<>();

    public AccountHolder() {
    }

    public AccountHolder(String name, String password, LocalDate dateOfBirth, Address primaryAddress) {
        super(name, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;

    }


    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountListSecundaryOwner() {
        return accountListSecundaryOwner;
    }

    public void setAccountListSecundaryOwner(List<Account> accountListSecundaryOwner) {
        this.accountListSecundaryOwner = accountListSecundaryOwner;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAdress() {
        return primaryAddress;
    }

    public void setPrimaryAdress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
