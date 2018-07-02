package telran.weather;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import telran.weather.WeatherForecaster;

public class WeatherForecasterTest {
	
	@Test
	public void testGetForecastByCity() {
		WeatherForecaster forecaster = new WeatherForecaster();
		assertTrue("weather is positive", forecaster.getForecastByCity("PARIS") > 0);
	}

}
