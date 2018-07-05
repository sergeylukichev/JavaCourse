package telran.weather;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import telran.weather.ForecastResult;
import telran.weather.SearchResult;

public class WeatherForecaster {
	
	DataSource source;
		
	public WeatherForecaster(DataSource source) {
		this.source = source;
	}
	
	public double getForecastByCity(String city) {
		return 0;
	}
	
	public SearchResult findLocationByCityName(String city) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Optional<String> searchResultString = source.readSearchResults(city);
		if(searchResultString.isPresent()) {
			SearchResult[] results = mapper.readValue(searchResultString.get(), SearchResult[].class);
			return results[0];
		} else {
			throw new Exception("No locations found for city "+city);
		}
		
	}
	
	public ForecastResult getForecast(String woeid) {
		return null;
	}
	
}
