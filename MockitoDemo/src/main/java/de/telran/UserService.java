package de.telran;

public class UserService {
	
	UserGateway gateway;
	
	public UserService(UserGateway gateway) {
		this.gateway = gateway;
	}

	public String getUserData(User user, boolean order) {

		if(user==null) {
			return "user is not set";
		}
		if(order) {
			user = new User(user.password, user.username);
			return gateway.getUserDataString(user); 
		} else {
			return gateway.getRewerseUserDataString(user); 
		}
	}
}
