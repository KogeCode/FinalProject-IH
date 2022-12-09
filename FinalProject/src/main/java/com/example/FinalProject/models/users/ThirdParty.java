package com.example.FinalProject.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ThirdParty extends User {
    @NotEmpty
    private String hashedKey;

    public ThirdParty() {
    }

    public ThirdParty(String name, String password, String hashedKey) {
        super(name, password);
        hashedKey = hashedKey;
    }


    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        hashedKey = hashedKey;
    }
}
