package de.telra.gateway;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import de.telran.gateway.ItemGateway;
import de.telran.gateway.UserGateway;
import de.telran.model.Item;
import de.telran.model.Token;
import de.telran.model.User;


public class ItemGatewayTest {
	
	@Test
	public void testCreateItem() {
		
		ItemGateway gateway = new ItemGateway(new RestTemplate());
		Token token = loginUser();
		boolean createItem = gateway.createItem(createTestItem(), token);
		assertTrue("item created", createItem);
		
	}
	
	private Token loginUser() {
		UserGateway userGateway = new UserGateway(new RestTemplate());
		return userGateway.login(new User("sergey2", "test"));
	}
	
	private Item createTestItem() {
		Item item = new Item();
		item.setItemName("Notebook");
		item.setItemType("Task");
		return item;
	}
}
