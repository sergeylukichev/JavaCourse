package de.telran.service;

import de.telran.exception.CityNotFoundException;
import de.telran.model.CityWeather;
import de.telran.model.WeatherForecast;
import de.telran.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private ExternalWeatherService externalWeatherService;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(ExternalWeatherService externalWeatherService,
                          WeatherRepository repository) {
        this.externalWeatherService = externalWeatherService;
        this.weatherRepository = repository;
    }

    public CityWeather getWeatherByCityName(String city) throws CityNotFoundException {
        System.out.println("city "+city);
        CityWeather byCity = weatherRepository.findByCity(city);
        System.out.println(" weather from the repo "+ byCity);
        if(byCity == null) {
            WeatherForecast weatherForCity = externalWeatherService.getWeatherForCity(city);
            System.out.println(weatherForCity);
            CityWeather cityWeather = createCityWeather(weatherForCity);
            weatherRepository.save(cityWeather);
            return cityWeather;
        }
        return byCity;
    }

    private CityWeather createCityWeather(WeatherForecast forecast) {
        return new CityWeather(forecast.getTitle().toLowerCase(), forecast.getTemp());
    }
}
