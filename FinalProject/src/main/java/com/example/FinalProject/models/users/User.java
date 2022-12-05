package com.example.FinalProject.models.users;

import jakarta.persistence.*;

@Entity
public abstract class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long userId;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
