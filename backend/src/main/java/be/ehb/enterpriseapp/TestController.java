package be.ehb.enterpriseapp;

import be.ehb.enterpriseapp.auth.models.SecurityUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TestController {

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal SecurityUser user) {
        return "if you see this, you are logged in " + user.getUsername() + " " + user.getAuthorities() + " " + user.getPassword() + " " + user.getId();
    }


    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal SecurityUser user) {
        return "if you see this, you are an admin " + user.getUsername() + " " + user.getAuthorities() + " " + user.getPassword() + " " + user.getId();
    }
}
