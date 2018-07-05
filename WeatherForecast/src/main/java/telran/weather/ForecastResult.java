package telran.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResult {
	
	ConsolidatedWeather [] consolidatedWeather;
	
	public ForecastResult() {}

}
