package de.telran.weather.service;

import de.telran.weather.entity.ConsolidatedWeather;
import de.telran.weather.entity.Forecast;
import de.telran.weather.entity.SearchResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {

    private WeatherGateway gateway = mock(WeatherGateway.class);

    @Test
    public void testGetWeatherByCityName() throws Exception {

        when(gateway.findCityByName(anyString())).thenReturn(createSearchResult());
        when(gateway.getWeatherByWoeid(anyString())).thenReturn(createTestForecast());

        WeatherService service = new WeatherService(gateway);

        String weatherInBerlin = service.getWeatherByCityName("Berlin");

        assertEquals("25", weatherInBerlin);


    }

    private SearchResult[] createSearchResult() {
        SearchResult result = new SearchResult("1234");
        SearchResult [] results = {result};
        return results;
    }

    private Forecast createTestForecast() {
        ConsolidatedWeather weather = new ConsolidatedWeather("25");
        ConsolidatedWeather [] results = {weather};
        Forecast forecast = new Forecast(results);
        return forecast;
    }
}
