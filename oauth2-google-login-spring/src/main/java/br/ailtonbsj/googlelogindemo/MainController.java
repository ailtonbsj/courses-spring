package br.ailtonbsj.googlelogindemo;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {
    @GetMapping("/")
    public String home() {
        return "Hello!";
    }

    @GetMapping("/demo")
    public String demo() {
        return "Demo.";
    }

    @GetMapping("/google")
    public String currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
    }

    @GetMapping("/auth")
    public String anotherUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
    }
}
