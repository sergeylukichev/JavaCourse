package de.telran;

import de.telran.gateway.ProjectGateway;
import de.telran.gateway.UserGateway;
import de.telran.model.Item;
import de.telran.model.Token;
import de.telran.model.User;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        UserGateway gateway = new UserGateway(restTemplate);
        User user = new User("Sergey", "Lukichev", "test", "test", "ser");
        //gateway.register(user);
        Token login = gateway.login(user);
        System.out.println(login);

        ProjectGateway projectGateway = new ProjectGateway(restTemplate);
        projectGateway.createItem(new Item("Test", "Task"), login);
    }
}
