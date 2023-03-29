package hr.fer.lab1.rest;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomepageController {

    @GetMapping("")
    public String getHomepage(JwtAuthenticationToken token) {
        return String.format("Welcome to the homepage, %s! Your access token authorities are: %s.", token.getName(), token.getAuthorities());
    }
}
