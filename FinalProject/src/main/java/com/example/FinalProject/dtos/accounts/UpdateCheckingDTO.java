package com.example.FinalProject.dtos.accounts;

import com.example.FinalProject.enums.Status;

public class UpdateCheckingDTO {
    private Long newCheckingId;
    private String newSecretKey;
    private Status newStatus;

    public UpdateCheckingDTO() {
    }

    public UpdateCheckingDTO(Long newCheckingId, String newSecretKey, Status newStatus) {
        this.newCheckingId = newCheckingId;
        this.newSecretKey = newSecretKey;
        this.newStatus = newStatus;
    }

    public Long getNewCheckingId() {
        return newCheckingId;
    }

    public void setNewCheckingId(Long newCheckingId) {
        this.newCheckingId = newCheckingId;
    }

    public String getNewSecretKey() {
        return newSecretKey;
    }

    public void setNewSecretKey(String newSecretKey) {
        this.newSecretKey = newSecretKey;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }
}
