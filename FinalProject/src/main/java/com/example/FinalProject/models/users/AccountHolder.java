package com.example.FinalProject.models.users;

import com.example.FinalProject.models.account.Account;
import com.example.FinalProject.models.embedded.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class AccountHolder extends User{

    private Date dateOfBirth;

    @Embedded
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "physical_address")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "physical_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "physical_city")),
            @AttributeOverride(name = "country", column = @Column(name = "physical_country"))
    }
    )
    private Address mailingAddress;

    @OneToMany(mappedBy = "accountHolder", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Account> accountList;
    @OneToMany(mappedBy ="accountHolderSecundary" )
    @JsonIgnore
    private List<Account> accountListSecundaryOwner;

    public AccountHolder() {
    }

    public AccountHolder(String name, String password, Date dateOfBirth, Address primaryAddress, Address mailingAddress, List<Account> accountList) {
        super(name, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.accountList = accountList;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAdress() {
        return primaryAddress;
    }

    public void setPrimaryAdress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
