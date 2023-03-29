package hr.fer.lab1.rest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String getPrincipalInfo(KeycloakAuthenticationToken token) {
        return ((KeycloakPrincipal<?>)token.getPrincipal()).getKeycloakSecurityContext().getTokenString()
                + "\n" +
                ((KeycloakPrincipal<?>)token.getPrincipal()).getKeycloakSecurityContext().getIdTokenString();
    }
}
