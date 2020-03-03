package de.telran;

import de.telran.gateway.UserGateway;
import de.telran.model.Token;
import de.telran.model.User;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();
        UserGateway gateway = new UserGateway(rest);
        //gateway.register(createTestUser());

        Token login = gateway.login(createTestUser());
        System.out.println(login);
    }

    private static User createTestUser() {
        return new User("test",
                "test",
                "ivan",
                "petrov",
                "test");
    }
}
