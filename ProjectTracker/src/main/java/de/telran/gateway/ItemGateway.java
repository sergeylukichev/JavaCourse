package de.telran.gateway;

import org.springframework.web.client.RestTemplate;

import de.telran.model.Item;
import de.telran.model.Token;

public class ItemGateway {
	
	RestTemplate rest;
	String itemsCreaterUrl = "http://localhost:8080/items/create";
	
	public ItemGateway(RestTemplate rest) {
		this.rest = rest;
	}
	
	public boolean createItem(Item item, Token token) {
		return false;		
	}

}
