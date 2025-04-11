package com.afitech.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;

    // Explicit getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
