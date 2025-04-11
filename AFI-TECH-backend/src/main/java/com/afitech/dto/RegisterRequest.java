package com.afitech.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String password;
    private String role; // Doit correspondre aux noms de rôles dans Role.RoleName

    // Explicit getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
