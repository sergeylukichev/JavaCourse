package de.telran.gateway;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import de.telran.model.Token;
import de.telran.model.User;

public class UserGateway {
	String registerUrl = "http://localhost:8080/user/register";
	String loginUrl = "http://localhost:8080/user/login";
	
	RestTemplate rest;
	
	public UserGateway(RestTemplate rest) {
		this.rest = rest;
		this.rest.setErrorHandler(new RestTemplateResponseErrorHanlder());
		
	}
	
	public boolean register(User user) {
		HttpEntity<User> userRequest = new HttpEntity<>(user, null);
		ResponseEntity<Void> exchange = rest.exchange(registerUrl, HttpMethod.POST, userRequest, Void.class);
		return exchange.getStatusCode() == HttpStatus.OK;
	}
	
	public Token login(User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> userRequest = new HttpEntity<>(user, headers);
		ResponseEntity<Token> exchange = rest.exchange(loginUrl, HttpMethod.POST, userRequest, Token.class);
		Token token = exchange.getBody();
		return token;		
	}
}
