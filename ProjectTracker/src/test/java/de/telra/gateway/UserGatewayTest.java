package de.telra.gateway;

import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withUnauthorizedRequest;

import de.telran.gateway.UserGateway;
import de.telran.model.Token;
import de.telran.model.User;

public class UserGatewayTest {
	
	private static String registerUrl = "http://localhost:8080/user/register";
	private static String loginUrl = "http://localhost:8080/user/login";

	RestTemplate restTemplate = new RestTemplate();
	UserGateway gateway = new UserGateway(restTemplate);
	
	//mock creation
	MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
	
	@Test
	public void testRegisterUser() {		
		//mock definition/behavior
		server.expect(ExpectedCount.manyTimes(), requestTo(registerUrl))
			.andExpect(method(HttpMethod.POST))
			.andExpect(content().json(registerJson))
		    .andRespond(withSuccess("", MediaType.APPLICATION_JSON));
		 
		//calling testing method
		boolean register = gateway.register(createTestUser());
		
		//verifying output
		assertTrue("user created", register);		
	}	
	
	@Test
	public void testRegisterDuplicateUser() {
		server.expect(ExpectedCount.manyTimes(), requestTo(registerUrl)).andExpect(method(HttpMethod.POST))
		     .andRespond(withServerError());
		 
		boolean isRegistered = gateway.register(createTestUser());
		
		assertFalse("is registered", isRegistered);
	}
	
	@Test 
	public void testLoginUser() {
		
		server.expect(ExpectedCount.manyTimes(), requestTo(loginUrl))
		.andExpect(method(HttpMethod.POST))
		.andExpect(content().json(loginJson))
		.andRespond(withSuccess(tokenJson, MediaType.APPLICATION_JSON));
		
		Token token = gateway.login(createTestUser());
		
		assertNotNull("token", token);
	}
	
	@Test 
	public void testLoginUserFailed() {
		
		server.expect(ExpectedCount.manyTimes(), requestTo(loginUrl))
			.andExpect(method(HttpMethod.POST))
			.andExpect(content().json(loginJson))
			.andRespond(withUnauthorizedRequest());
		
		Token token = gateway.login(createTestUser());

		assertNull("token", token);
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

	static String registerJson = "{\"firstName\":\"Sergey\", \"lastName\":\"Lukichev\", \"password\":\"test\", \"repeatPassword\":\"test\", \"username\":\"sergey2\"}";
	static String loginJson = "{ \"password\":\"test\", \"username\":\"sergey2\"}";
	static String tokenJson = "{\"token\":\"936017e1-48ba-4b1b-905f-6404845f8ff8\"}";
}