package be.ehb.enterpriseapp.config;

import be.ehb.enterpriseapp.auth.models.SecurityUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthenticationToken extends AbstractAuthenticationToken {

    private final SecurityUser user;

    public UserAuthenticationToken(SecurityUser user) {
        super(user.getAuthorities());
        this.user = user;
        setAuthenticated(true);
    }



    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public SecurityUser getPrincipal() {
        return user;
    }
}
