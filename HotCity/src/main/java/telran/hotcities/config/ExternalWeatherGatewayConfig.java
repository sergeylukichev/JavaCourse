package telran.hotcities.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import telran.hotcities.gateway.ExternalWeatherGateway;

@Configuration
public class ExternalWeatherGatewayConfig {
	
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	public ExternalWeatherGateway getWeatherGateway() throws Exception {
		return new ExternalWeatherGateway("https://www.metaweather.com/api/location/search",
		"https://www.metaweather.com/api/location/",
		getRestTemplate());
	}
	
	@Bean
	public CustomRestTemplateCustomizer getCustomizer() {
		return new CustomRestTemplateCustomizer();
	}
	
	@Bean
	public RestTemplate getRestTemplate() throws Exception {
		RestTemplate template = builder
				.additionalCustomizers(getCustomizer())
				.build();
		return template;
	}
	
	@Bean
	public ObjectMapper jacksonObjectMapper() {
		return new ObjectMapper()
				.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
	}
}
