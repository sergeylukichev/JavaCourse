package de.telran.service;

import de.telran.exception.CityNotFoundException;
import de.telran.gateway.ExternalWeatherGateway;
import de.telran.model.SearchResult;
import de.telran.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalWeatherService {

    private ExternalWeatherGateway gateway;

    public ExternalWeatherService(@Autowired ExternalWeatherGateway gateway) {
        this.gateway = gateway;
    }

    public WeatherForecast getWeatherForCity(String city) throws CityNotFoundException{
        Optional<SearchResult> searchResultsByCityName = gateway.getSearchResultsByCityName(city);
        return searchResultsByCityName
                .map(searchResult -> gateway.getForecast(searchResult.getWoeid()))
                .orElseThrow(() -> new CityNotFoundException("city "+city+" not found"));
    }
}
