package com.example.FinalProject.models.users;

import jakarta.persistence.*;

@Entity
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    private Long adminId;

    public Admin() {
    }

    public Admin(String name) {
        super(name);
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    //CREAR METODO PARA CREAR CUENTAS (solo checking, saving, CreditCard)
}

