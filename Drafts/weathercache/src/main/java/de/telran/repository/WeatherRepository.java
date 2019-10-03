package de.telran.repository;

import de.telran.model.CityWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<CityWeather, Long> {
    CityWeather findByCity(String city);

}
