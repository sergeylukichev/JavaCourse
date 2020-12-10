package de.telran.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsolidatedWeather {
    private String theTemp;

    public ConsolidatedWeather() {

    }

    public ConsolidatedWeather(String theTemp) {
        this.theTemp = theTemp;
    }

    public String getTheTemp() {
        return theTemp;
    }

    public void setTheTemp(String theTemp) {
        this.theTemp = theTemp;
    }

    @Override
    public String toString() {
        return "ConsolidatedWeather{" +
                "theTemp='" + theTemp + '\'' +
                '}';
    }
}
