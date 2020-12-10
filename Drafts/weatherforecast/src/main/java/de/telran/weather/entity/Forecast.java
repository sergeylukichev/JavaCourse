package de.telran.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private ConsolidatedWeather[] consolidatedWeather;

    public Forecast() {

    }

    public Forecast(ConsolidatedWeather[] consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }

    public ConsolidatedWeather[] getConsolidatedWeather() {
        return consolidatedWeather;
    }

    public void setConsolidatedWeather(ConsolidatedWeather[] consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "consolidatedWeather=" + Arrays.toString(consolidatedWeather) +
                '}';
    }
}
