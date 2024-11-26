package be.ehb.enterpriseapp.auth.controllers;

import be.ehb.enterpriseapp.auth.models.LoginRequest;
import be.ehb.enterpriseapp.auth.models.LoginResponse;
import be.ehb.enterpriseapp.auth.models.SecurityUser;
import be.ehb.enterpriseapp.auth.models.User;
import be.ehb.enterpriseapp.auth.services.AuthService;
import be.ehb.enterpriseapp.config.JwtIssuer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

      @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }



}
