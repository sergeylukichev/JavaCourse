package de.telran.gateway;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import de.telran.model.Token;
import de.telran.model.User;

public class UserGateway {
	String registerUrl = "http://localhost:8080/user/register";
	String loginUrl = "http://localhost:8080/user/login";
	RestTemplate rest;
	
	public UserGateway(RestTemplate rest) {
		this.rest = rest;
		
	}
	
	public boolean register(User user) {
		return false;
	}
	
	public String login(User user) {
		return null;	
	}
	
	private void configureConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setPrettyPrint(false);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(
			    PropertyNamingStrategy.SNAKE_CASE);	
		
		messageConverter.setObjectMapper(mapper);
		rest.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
		rest.getMessageConverters().add(messageConverter);
	}

}
