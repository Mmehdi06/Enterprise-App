package be.ehb.enterpriseapp.auth.repositories;

import be.ehb.enterpriseapp.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository< User, Long > {
    Optional< User > findByEmail( String email );
}
