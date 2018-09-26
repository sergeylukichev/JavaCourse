package telran.hotcities.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ConsolidatedWeather {
	
	private double theTemp;
	
	public ConsolidatedWeather() {}

	public double getTheTemp() {
		return theTemp;
	}

	public void setTheTemp(double theTemp) {
		this.theTemp = theTemp;
	}

	@Override
	public String toString() {
		return "ConsolidatedWeather [theTemp=" + theTemp + "]";
	}
}
