package de.telran.gateway;

import de.telran.model.Item;
import de.telran.model.Token;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ProjectGateway {

    RestTemplate rest;

    private static String CREATE_ITEM_URL = "http://localhost:8080/items/create";
    public ProjectGateway(RestTemplate rest) {
        this.rest = rest;
    }

    public void createItem(Item item, Token token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token.getToken());
        HttpEntity<Item> itemHttpEntity = new HttpEntity<>(item, headers);

        ResponseEntity<Void> exchange = rest.exchange(CREATE_ITEM_URL, HttpMethod.POST, itemHttpEntity, Void.class);
    }

}
