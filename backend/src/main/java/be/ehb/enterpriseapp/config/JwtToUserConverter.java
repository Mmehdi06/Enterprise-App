package be.ehb.enterpriseapp.config;

import be.ehb.enterpriseapp.auth.enums.UserRole;
import be.ehb.enterpriseapp.auth.models.SecurityUser;
import be.ehb.enterpriseapp.auth.models.User;
import be.ehb.enterpriseapp.auth.repositories.UserRepository;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtToUserConverter{

    private final UserRepository userRepository;

    public JwtToUserConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SecurityUser convert(DecodedJWT jwt) {
        var userEmail = jwt.getClaim("email").asString();

        Optional<User> optionalUser = userRepository.findByEmail(userEmail);

        User user = optionalUser.orElseThrow(() ->
                new RuntimeException("User not found for email: " + userEmail)
        );

        return new SecurityUser(user);
    }


}
