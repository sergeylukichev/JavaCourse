package telran.weather;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import telran.weather.DataSource;
import telran.weather.ForecastResult;
import telran.weather.SearchResult;
import telran.weather.exception.LocationNotFoundException;

public class WeatherForecaster {
	
	DataSource source = new DataSource();
	ObjectMapper objectMapper = new ObjectMapper();
		
	public WeatherForecaster(DataSource source) {
		this.source = source;
		objectMapper.setPropertyNamingStrategy(
			    PropertyNamingStrategy.SNAKE_CASE);		
	}
	
	public double getForecastByCity(String city) throws Exception {
		SearchResult result = findLocationByCityName(city);
		ForecastResult forecast = getForecast(result.getWoeid());
		return forecast.getConsolidatedWeather()[0].theTemp;
	}
	
	public SearchResult findLocationByCityName(String city) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Optional<String> searchResultString = source.readSearchResults(city);
		if(searchResultString.isPresent()) {
			SearchResult[] results = mapper.readValue(searchResultString.get(), SearchResult[].class);
			return results[0];
		} else {
			throw new LocationNotFoundException("No locations found for city "+city);
		}	
	}
	
	public ForecastResult getForecast(String woeid) throws Exception {
		Optional<String> resultString = source.readForecast(woeid);
		if(resultString.isPresent()) {
			ForecastResult forecast = objectMapper.readValue(resultString.get(), ForecastResult.class);
			return forecast;
		} else {
			throw new Exception ("No forecast found for woeid "+woeid);
		}
	}
}
