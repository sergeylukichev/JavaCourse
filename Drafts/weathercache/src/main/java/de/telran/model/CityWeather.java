package de.telran.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class CityWeather {
    private @Id @GeneratedValue Long id;
    String city;
    double temp;

    public CityWeather() {

    }

    public CityWeather(String city, double temp) {
        this.city = city;
        this.temp = temp;
    }
}
