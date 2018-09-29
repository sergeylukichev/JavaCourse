package telran.hotcities.controller;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import telran.hotcities.gateway.ExternalWeatherGateway;
import telran.hotcities.model.ConsolidatedWeather;
import telran.hotcities.model.SearchResult;
import telran.hotcities.model.WeatherForecast;
import telran.hotcities.service.WeatherService;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class WeatherServiceTest {

  @MockBean
  private ExternalWeatherGateway gateway;

  WeatherService service;

  @Before
  public void setUp() {
      service = new WeatherService(gateway);
  }

  @Test
  public void testGetSearchResult() throws Exception {
	  
	  //defining test data
      SearchResult berlinResult = new SearchResult();
      berlinResult.setTitle("berlin");
      berlinResult.setWoeid("11111");

      SearchResult parisResult = new SearchResult();
      parisResult.setTitle("paris");
      parisResult.setWoeid("22222");

      ConsolidatedWeather consolidatedWeather = new ConsolidatedWeather();
      consolidatedWeather.setTheTemp(33);
      ConsolidatedWeather [] weather = {consolidatedWeather};
      WeatherForecast berlinForecast = new WeatherForecast();
      berlinForecast.setConsolidatedWeather(weather);
      berlinForecast.setTitle("berlin");

      WeatherForecast parisForecast = new WeatherForecast();
      parisForecast.setConsolidatedWeather(weather);
      parisForecast.setTitle("berlin");

      //configuring mocks with the test data above
      when(gateway.getSearchResultsByCityName(eq("berlin"))).thenReturn(Optional.of(berlinResult));
      when(gateway.getForecast(eq("11111"))).thenReturn(berlinForecast);

      when(gateway.getSearchResultsByCityName(eq("paris"))).thenReturn(Optional.of(parisResult));
      when(gateway.getForecast(eq("22222"))).thenReturn(parisForecast);

      //executing service call
      String [] cities = {"berlin","paris"};
      service.getHottestCity(cities);

      //verifying 
      verify(gateway, times(1)).getSearchResultsByCityName("berlin");
      verify(gateway, times(1)).getForecast("11111");
      verify(gateway, times(1)).getSearchResultsByCityName("paris");
      verify(gateway, times(1)).getForecast("22222");

  }
}