package telran.hotcities.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsolidatedWeather {
	
	private double theTemp;
	
	@JsonCreator
	public ConsolidatedWeather(@JsonProperty("the_temp") double theTemp) {
		this.theTemp = theTemp;
	}
	
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
