package telran.hotcities.gateway;

import org.springframework.web.client.RestTemplate;

import telran.hotcities.model.SearchResult;
import telran.hotcities.model.WeatherForecast;

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
	
	public SearchResult getSearchResultsByCityName(String city) {
		return null;
	}
	
	public WeatherForecast getForecast(String woeid) {
		return null;
	}

}
