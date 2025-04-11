package com.afitech.service.impl;

import com.afitech.dto.LoginRequest;
import com.afitech.dto.RegisterRequest;
import com.afitech.modele.Role;
import com.afitech.modele.User;
import com.afitech.repository.RoleRepository;
import com.afitech.repository.UserRepository;
import com.afitech.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User register(RegisterRequest request) {
        Role role = roleRepository.findByName(Role.RoleName.valueOf(request.getRole().toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        return userRepository.save(user);
    }

    @Override
    public User authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        return userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
