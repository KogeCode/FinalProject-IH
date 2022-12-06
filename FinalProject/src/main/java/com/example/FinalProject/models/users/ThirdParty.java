package com.example.FinalProject.models.users;

import jakarta.persistence.*;

@Entity
public class ThirdParty extends User {

    private String HashedKey;

    public ThirdParty() {
    }

    public ThirdParty(String name, String password, String hashedKey) {
        super(name, password);
        HashedKey = hashedKey;
    }


    public String getHashedKey() {
        return HashedKey;
    }

    public void setHashedKey(String hashedKey) {
        HashedKey = hashedKey;
    }
}
