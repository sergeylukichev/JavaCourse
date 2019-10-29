package de.telran.controller;

import de.telran.exception.CityNotFoundException;
import de.telran.model.CityWeather;
import de.telran.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/weather/{city}")
    CityWeather getCityWeather(@PathVariable String city) throws CityNotFoundException {
        return service.getWeatherByCityName(city);
    }
}
