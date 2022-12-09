package com.example.FinalProject.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Admin extends User{
    @NotEmpty
    private String nameAdmin;

    public Admin() {
    }

    public Admin(String name, String password, String nameAdmin) {
        super(name, password);
        this.nameAdmin=nameAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }
}


