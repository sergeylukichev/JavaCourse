package de.telran;

public class User {
	
	String username;
	String password;
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	

}
