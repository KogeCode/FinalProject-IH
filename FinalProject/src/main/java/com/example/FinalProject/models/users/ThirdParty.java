package com.example.FinalProject.models.users;

import jakarta.persistence.*;

@Entity
public class ThirdParty extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thirdparty_id" , nullable = false)
    private Long thirdPartyId;
    private String HashedKey;

    public ThirdParty() {
    }

    public ThirdParty(String name, String hashedKey) {
        super(name);
        HashedKey = hashedKey;
    }

    public Long getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(Long thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getHashedKey() {
        return HashedKey;
    }

    public void setHashedKey(String hashedKey) {
        HashedKey = hashedKey;
    }
}
