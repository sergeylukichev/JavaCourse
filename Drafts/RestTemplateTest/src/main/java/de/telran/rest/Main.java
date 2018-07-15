package de.telran.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		String weatherForecastQueryURL
		  = "https://www.metaweather.com/api/location/search?query=Paris";
		
		ResponseEntity<String> response
		  = restTemplate.getForEntity(weatherForecastQueryURL, String.class);
		
		System.out.println(response.getBody());
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getHeaders());
		
		SearchResult[] results = restTemplate.getForObject(weatherForecastQueryURL, SearchResult[].class);
		
		for(SearchResult result:results) {
			System.out.println(result);
		}

		//HttpEntity<String> entity = new HttpEntity<>(new HttpHeaders());
		
		ResponseEntity<SearchResult[]> exchange = 
				restTemplate
				.exchange("https://www.metaweather.com/api/location/search?query={1}&query2={2}", 
						HttpMethod.GET, 
						null, 
						SearchResult[].class, "Paris", "Berlin");
		
		System.out.println("Search result "+exchange.getBody()[0]);
		
//		String userRegisterURL = "http://localhost:8080/user/register";
//		User userToRegister = new User("sergey7756","qqq", "sergey", "lukichev", "qqq");
//		
//		ResponseEntity<Void> postForEntity = restTemplate.postForEntity(userRegisterURL, userToRegister, Void.class);
//		
//		System.out.println(postForEntity.getStatusCodeValue());
		
		
		HttpEntity<User> request1 = new HttpEntity<>(new User("sergey7756", "qqq"));
		ResponseEntity<Token> response1 = restTemplate
		  .exchange("http://localhost:8080/user/login", HttpMethod.POST, request1, Token.class);
		
		Token token = response1.getBody();
		System.out.println("TOKEN "+token.token);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token.token);
		
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> exchange2 = 
				restTemplate.exchange("http://localhost:8080/items/all", 
						HttpMethod.GET, 
						entity, 
						String.class);
		
		System.out.println(exchange2.getBody());
		System.out.println(exchange2.getStatusCodeValue());
	}

}
