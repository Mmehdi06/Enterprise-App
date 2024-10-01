package be.ehb.enterpriseapp.models;

import be.ehb.enterpriseapp.models.enums.UserRole;
import jakarta.persistence.*;


@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    
    @Enumerated (EnumType.STRING)
    private UserRole userRole; // STUDENT, SUPERVISOR, ADMIN
}
