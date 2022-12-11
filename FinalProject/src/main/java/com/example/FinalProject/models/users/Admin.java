package com.example.FinalProject.models.users;

import jakarta.persistence.Entity;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Admin extends User{
    private String nameAdmin;

    public Admin() {
    }

    public Admin(String name, String password) {
        super(name, password);

    }


}


