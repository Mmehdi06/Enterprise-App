package be.ehb.enterpriseapp.auth.models;

import be.ehb.enterpriseapp.auth.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table (name = "users")
public class User implements UserDetails {
    public static Object UserRole;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @JsonIgnore
    private String password;

    @Enumerated (EnumType.STRING)
    private UserRole userRole; // STUDENT, ADMIN
    

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    public User(String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User() {
    }

    @Override
    public String getUsername() {
        return email;
    }
    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }
    
    public String getEmail ( ) {
        return email;
    }
    
    public void setEmail ( String email ) {
        this.email = email;
    }
    
    public UserRole getUserRole ( ) {
        return userRole;
    }
    
    public void setUserRole ( UserRole userRole ) {
        this.userRole = userRole;
    }
    
}
