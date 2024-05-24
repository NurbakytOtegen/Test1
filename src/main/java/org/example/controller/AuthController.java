package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.dto.JWTAuthResponse;
import org.example.dto.LoginDto;
import org.example.dto.RegistrationDto;
import org.example.dto.UserDTO;
import org.example.service.JwtAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtAuthService jwtAuthService;
    @PostMapping("/login")
    public JWTAuthResponse login(@RequestBody LoginDto loginDto){
        return jwtAuthService.login(loginDto);
    }
    @PostMapping("/registration")
    public JWTAuthResponse registration(@RequestBody RegistrationDto registrationDto){
        return jwtAuthService.registration(registrationDto);
    }

//    @GetMapping(name = "/test")
//    @Operation(summary = "Доступен только авторизованным пользователям")
//    public String example() {
//        return "Hello, world!";
//    }
}
