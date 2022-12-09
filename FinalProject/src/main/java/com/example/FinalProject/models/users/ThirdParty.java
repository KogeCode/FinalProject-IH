package com.example.FinalProject.models.users;

import jakarta.persistence.Entity;

@Entity
public class ThirdParty extends User {
    private String hashedKey;

    public ThirdParty() {
    }

    public ThirdParty(String name, String password, String hashedKey) {
        super(name, password);
        this.hashedKey = hashedKey;
    }


    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey= hashedKey;
    }
}
