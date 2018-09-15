package telran.hotcities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import telran.hotcities.gateway.ExternalWeatherGateway;

@Configuration
public class ExternalWeatherGatewayConfig {
	
	@Bean
	public ExternalWeatherGateway getWeatherGateway() {
		return new ExternalWeatherGateway("https://www.metaweather.com/api/location/search",
		"https://www.metaweather.com/api/location/",
		getRestTemplate());
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
