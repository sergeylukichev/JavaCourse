package de.telran.gateway;

import de.telran.model.SearchResult;
import de.telran.model.WeatherForecast;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class ExternalWeatherGateway {
	
	private String searchUrl;
	private String forecastUrl;
	private RestTemplate rest;
	
	public ExternalWeatherGateway(String searchUrl,
                                  String forecastUrl,
                                  RestTemplate rest) {
		this.searchUrl = searchUrl;
		this.forecastUrl = forecastUrl;
		this.rest = rest;
	}
	
	public Optional<SearchResult> getSearchResultsByCityName(String city) {
		final String url = searchUrl+"?query="+city;
		
		ResponseEntity<SearchResult[]> exchange = rest.exchange(url,  HttpMethod.GET, null, SearchResult[].class);

		SearchResult[] results = exchange.getBody();
		
		if(results.length == 0) {
			return Optional.empty();
		}
		
		return Optional.of(results[0]);
	}
	
	public WeatherForecast getForecast(String woeid) {
		final String url = forecastUrl+woeid;	
		ResponseEntity<WeatherForecast> exchange = rest.exchange(url,  HttpMethod.GET, null, WeatherForecast.class);
		return exchange.getBody();
	}
}
