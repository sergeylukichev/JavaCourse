package de.telran;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;


public class UserServiceTest {
	
	//mock creation
	UserGateway gateway = mock(UserGateway.class);
	
	
	@Test
	public void testGetUserData() {
		
		User user = new User("sergey", "lukichev");
		
		//define mock behavior
		when(gateway.getUserDataString(user)).thenReturn("sergeylukichev");

		//execute testing method
		UserService service = new UserService(gateway);
		
		String userData = service.getUserData(user, true);
		
		//verify results
		assertEquals("sergeylukichev", userData);
	}
	
	
	
	
	

	@Test
	public void testGetUserDataWithMatchers() {
		
		//define mock behavior
		when(gateway.getUserDataString(ArgumentMatchers.any()))
		.thenReturn("sergeylukichev");
		
		
		UserService service = new UserService(gateway);
		
		//execute test method
		User user1 = new User("sergey", "lukichev");
		String userData = service.getUserData(user1, true);
						
		assertEquals("sergeylukichev", userData);
		
		verify(gateway, Mockito.times(1)).getUserDataString(user1);
	}
	
	@Test
	public void testGetUserDataWithMatchersAndNull() {
		when(gateway.getUserDataString(ArgumentMatchers.any())).thenReturn("sergeylukichev");
		UserService service = new UserService(gateway);
		
		service.getUserData(null, true);
		verify(gateway, Mockito.never()).getUserDataString(null);
	}

	@Test
	public void testGetUserDataWithCaptor() {
		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		
		//define behavior
		when(gateway.getUserDataString(captor.capture())).thenReturn("sergeylukichev");
		UserService service = new UserService(gateway);
		
		//execute test method
		User user = new User("aaa", "bbb");
		service.getUserData(user, true);
		
		//verify
		verify(gateway, Mockito.times(1)).getUserDataString(user);
		
		User userCaptured = captor.getValue();
		
		assertEquals(userCaptured.username, "aaa");
		assertEquals(userCaptured.password, "bbb");
	}

}
