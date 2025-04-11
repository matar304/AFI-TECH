package com.afitech.service;

import com.afitech.dto.RegisterRequest;
import com.afitech.dto.LoginRequest;
import com.afitech.modele.User;

public interface AuthenticationService {
    User register(RegisterRequest request);
    User authenticate(LoginRequest request);
}
