package telran.weather;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResult {
	
	ConsolidatedWeather [] consolidatedWeather;
	
	public ForecastResult() {}

	public ConsolidatedWeather[] getConsolidatedWeather() {
		return consolidatedWeather;
	}

	public void setConsolidatedWeather(ConsolidatedWeather[] consolidatedWeather) {
		this.consolidatedWeather = consolidatedWeather;
	}

	@Override
	public String toString() {
		return "ForecastResult [consolidatedWeather=" + Arrays.toString(consolidatedWeather) + "]";
	}
	
}
