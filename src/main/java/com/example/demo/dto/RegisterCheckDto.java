package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterCheckDto {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
