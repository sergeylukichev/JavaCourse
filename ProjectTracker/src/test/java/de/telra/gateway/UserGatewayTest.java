package de.telra.gateway;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import de.telran.gateway.UserGateway;
import de.telran.model.User;

public class UserGatewayTest {
	
	@Test
	public void testRegisterUser() {
		UserGateway gateway = new UserGateway(new RestTemplate());
		boolean register = gateway.register(createTestUser());
		assertTrue("user created", register);
	}
	
	@Test 
	public void testLoginUser() {
		UserGateway gateway = new UserGateway(new RestTemplate());
		String token = gateway.login(createTestUser());
		System.out.println("TOKEN "+token);
		assertNotNull("token", token);
	}
	
	private User createTestUser() {
		User user = new User();

		user.setFirstName("Sergey");
		user.setLastName("Lukichev");
		user.setPassword("test");;
		user.setRepeatPassword("test");
		user.setUsername("sergey2");
		return user;
	}

}
