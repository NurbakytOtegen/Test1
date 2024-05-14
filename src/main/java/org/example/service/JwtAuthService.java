package org.example.service;

import lombok.RequiredArgsConstructor;


import org.example.dto.JWTAuthResponse;
import org.example.dto.LoginDto;
import org.example.dto.RegistrationDto;
import org.example.entity.ERole;
import org.example.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtAuthService {
    private final UserService userService;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JWTAuthResponse registration(RegistrationDto registrationDto) {
        var user = User.builder()
                .username(registrationDto.getUsername())
                .email(registrationDto.getEmail())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .role(ERole.ROLE_USER)
                .build();
        userService.addUser(user);

        var jwt = jwtService.generateToken(user);
        return new JWTAuthResponse(jwt);
    }

    public JWTAuthResponse login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(loginDto.getUsername());

        var jwt = jwtService.generateToken(user);
        return new JWTAuthResponse(jwt);
    }
}
