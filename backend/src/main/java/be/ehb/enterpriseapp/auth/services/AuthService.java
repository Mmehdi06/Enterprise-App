package be.ehb.enterpriseapp.auth.services;

import be.ehb.enterpriseapp.auth.models.LoginResponse;
import be.ehb.enterpriseapp.auth.models.SecurityUser;
import be.ehb.enterpriseapp.config.JwtIssuer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public AuthService(JwtIssuer jwtIssuer, AuthenticationManager authenticationManager) {
        this.jwtIssuer = jwtIssuer;
        this.authenticationManager = authenticationManager;
    }


    public LoginResponse attemptLogin(String email, String password) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        var securityUser = (SecurityUser) authentication.getPrincipal();
        var user = securityUser.getUser(); // Get the User object from SecurityUser

        var roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        var token = jwtIssuer.issue(user.getId(), user.getEmail(), roles);

        return new LoginResponse(token);    }
}
