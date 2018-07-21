package de.telran;

public class UserGateway {
	
	public UserGateway() {
		
	}
	
	public String getUserDataString(User user) {
		//user == null
		return user.username+user.password;
	}
	
	public String getRewerseUserDataString(User user) {
		return user.password+user.username;
	}

}
