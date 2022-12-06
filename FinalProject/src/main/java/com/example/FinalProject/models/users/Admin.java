package com.example.FinalProject.models.users;

import jakarta.persistence.*;

@Entity
public class Admin extends User{
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

    //CREAR METODO PARA CREAR CUENTAS (solo checking, saving, CreditCard)

