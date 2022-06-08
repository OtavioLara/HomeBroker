package com.inter.investing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpRequest;

@Slf4j
@RestController
@RequestMapping("/")
public class AuthorizationController {

    @PostMapping
    public void authenticate() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8082/realms/inter"))
                .build();
        OAuth2ClientAutoConfiguration oAuth2ClientAutoConfiguration = new OAuth2ClientAutoConfiguration();
    }
}