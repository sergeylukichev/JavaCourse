package de.telran.gateway;

import de.telran.model.Token;
import de.telran.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserGateway {
    private final static String USER_REGISTER_URL =
            "http://localhost:8080/user/register";

    private final static String USER_LOGIN_URL =
            "http://localhost:8080/user/login";

    RestTemplate rest;

    public UserGateway(RestTemplate rest) {
        this.rest = rest;
    }

    public void register(User user) {
        HttpEntity<User> request = new HttpEntity<>(user);

        rest.exchange(USER_REGISTER_URL,
                HttpMethod.POST,
                request,
                Void.class);

    }

    public Token login(User user) {
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<Token> exchange = rest.exchange(USER_LOGIN_URL, HttpMethod.POST, request, Token.class);
        return exchange.getBody();
    }
}
