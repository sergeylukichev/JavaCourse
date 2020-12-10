package de.telran.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import de.telran.weather.entity.Forecast;
import de.telran.weather.entity.SearchResult;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeatherGatewayTest {

    @Test
    public void testFindCityByName() throws Exception {
        WeatherGateway gateway = new WeatherGateway(new ObjectMapper());

        SearchResult[] berlins = gateway.findCityByName("Berlin");

        assertTrue(berlins.length == 1);
    }

    @Test
    public void testGetWeatherByWoeid() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        WeatherGateway gateway = new WeatherGateway(mapper);
        Forecast weatherByWoeid = gateway.getWeatherByWoeid("638242");
        System.out.println(weatherByWoeid);
    }
}
