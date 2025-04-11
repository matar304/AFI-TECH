package com.afitech.controller;

import com.afitech.dto.LoginRequest;
import com.afitech.dto.LoginResponse;
import com.afitech.dto.RegisterRequest;
import com.afitech.modele.User;
import com.afitech.service.AuthenticationService;
import com.afitech.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        User user = authenticationService.register(request);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = authenticationService.authenticate(request);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        return ResponseEntity.ok(response);
    }
}
