package de.telran.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.weather.entity.Forecast;
import de.telran.weather.entity.SearchResult;

import java.net.URL;

public class WeatherGateway {

    private final String SEARCH_URL = "https://www.metaweather.com/api/location/search/?query=";
    private final String FORECAST_URL = "https://www.metaweather.com/api/location/";

    private ObjectMapper mapper;

    public WeatherGateway(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public SearchResult[] findCityByName(String cityName) throws Exception {

        URL searchUrl = new URL(SEARCH_URL + cityName);

        SearchResult[] searchResults = mapper.readValue(searchUrl, SearchResult[].class);

        return searchResults;
    }

    public Forecast getWeatherByWoeid(String woeid) throws Exception {
        URL forecastUrl = new URL(FORECAST_URL + woeid);

        Forecast forecast = mapper.readValue(forecastUrl, Forecast.class);

        return forecast;

    }
}
