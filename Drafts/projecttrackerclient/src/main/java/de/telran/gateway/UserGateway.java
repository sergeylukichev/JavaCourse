package de.telran.gateway;

import de.telran.model.Token;
import de.telran.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserGateway {

    private RestTemplate rest;
    private static String REGISTER_URL = "http://localhost:8080/user/register";
    private static String LOGIN_URL = "http://localhost:8080/user/login";

    public UserGateway(RestTemplate rest) {
        this.rest = rest;
    }

    public void register(User user) {
        HttpEntity<User> entity = new HttpEntity<>(user, null); //null for headers
        ResponseEntity<Void> exchange = rest.exchange(REGISTER_URL, HttpMethod.POST, entity, Void.class);
    }

    public Token login(User user) {

        HttpEntity<User> entity = new HttpEntity<>(user, null);
        ResponseEntity<Token> token = rest.exchange(LOGIN_URL, HttpMethod.POST, entity, Token.class);
        return token.getBody();
    }
}
