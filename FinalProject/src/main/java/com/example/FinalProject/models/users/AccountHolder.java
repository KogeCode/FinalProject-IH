package com.example.FinalProject.models.users;

import com.example.FinalProject.models.Adress;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AccountHolder extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountholder_id",nullable = false)
    private Long accountHolderId;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "primary_adress_adressid")
    private Adress primaryAdress;


    public AccountHolder() {
    }

    public AccountHolder(String name, Date dateOfBirth, Adress primaryAdress) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.primaryAdress = primaryAdress;
    }

    public Long getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(Long accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Adress getPrimaryAdress() {
        return primaryAdress;
    }

    public void setPrimaryAdress(Adress primaryAdress) {
        this.primaryAdress = primaryAdress;
    }
}
