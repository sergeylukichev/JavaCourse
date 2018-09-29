package telran.hotcities.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherForecast implements Comparable<WeatherForecast> {
	private String title;
	private ConsolidatedWeather[] consolidatedWeather;
	
	public WeatherForecast() {}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ConsolidatedWeather[] getConsolidatedWeather() {
		return consolidatedWeather;
	}
	public void setConsolidatedWeather(ConsolidatedWeather[] consolidatedWeather) {
		this.consolidatedWeather = consolidatedWeather;
	}
	
	public double getTemp() {
		return consolidatedWeather[0].getTheTemp();
	}

	@Override
	public String toString() {
		return "WeatherForecast [title=" + title + ", consolidatedWeather=" + Arrays.toString(consolidatedWeather)
				+ "]";
	}

	@Override
	public int compareTo(WeatherForecast o) {
		if(getTemp() > o.getTemp()) {
			return 1;
		} else if (getTemp() < o.getTemp()) {
			return -1;
		}
		return 0;
	}
}
