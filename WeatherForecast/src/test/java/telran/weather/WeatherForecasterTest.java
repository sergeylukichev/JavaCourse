package telran.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import telran.weather.WeatherForecaster;

public class WeatherForecasterTest {
	
	WeatherForecaster forecaster;
	
	@Before
	public void setUp() {
		forecaster = new WeatherForecaster(new DataSource());
	}
	
	@Test
	public void testGetForecastByCity() {
		assertTrue("weather must be positive", forecaster.getForecastByCity("PARIS") > 0);
	}
	
	@Test
	public void testFindLocationByCityName() throws Exception {		
		SearchResult result = forecaster.findLocationByCityName("Paris");
		assertNotNull(result);
		assertEquals("woeid", "615702", result.getWoeid());
	}
	
	@Test
	public void testGetForecast() throws Exception {
		ForecastResult forecast = forecaster.getForecast("615702");
		assertNotNull(forecast);
	}	

}
