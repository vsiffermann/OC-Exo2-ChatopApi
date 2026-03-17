package com.openclassrooms.chatopapi.controller;

import com.openclassrooms.chatopapi.dto.AuthResponseDTO;
import com.openclassrooms.chatopapi.dto.LoginRequestDTO;
import com.openclassrooms.chatopapi.dto.RegisterRequestDTO;
import com.openclassrooms.chatopapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}