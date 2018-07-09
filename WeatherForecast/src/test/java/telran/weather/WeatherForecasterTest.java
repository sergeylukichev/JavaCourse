package telran.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import telran.weather.SearchResult;
import telran.weather.DataSource;
import telran.weather.WeatherForecaster;

public class WeatherForecasterTest {
	
	WeatherForecaster forecaster;
	
	DataSource s = mock(DataSource.class);
	
	@Before
	public void setUp() throws Exception {
		forecaster = new WeatherForecaster(s);
	}
	
	@Test
	public void testGetForecastByCity() throws Exception {
		when(s.readSearchResults("Paris")).thenReturn(Optional.of(SEARCH_RESULTS));
		when(s.readForecast("615702")).thenReturn(Optional.of(FORECAST));
		assertTrue("weather must be positive", forecaster.getForecastByCity("Paris") > 0);
	}
	
	@Test
	public void testFindLocationByCityName() throws Exception {		
		when(s.readSearchResults("Paris")).thenReturn(Optional.of(SEARCH_RESULTS));
		SearchResult result = forecaster.findLocationByCityName("Paris");
		assertNotNull(result);
		assertEquals("woeid", "615702", result.getWoeid());
	}
	
	@Test
	public void testGetForecast() throws Exception {
		when(s.readForecast("615702")).thenReturn(Optional.of(FORECAST));
		ForecastResult forecast = forecaster.getForecast("615702");
		assertNotNull(forecast);
		assertTrue("results are not empty", forecast.getConsolidatedWeather().length > 0);
	}	
	
	private static final String FORECAST = "{\"consolidated_weather\": [{\"id\": 4580173110312960,\"the_temp\": 31.71},{\"id\": 6262022240993280,\"the_temp\": 21.31}]}";
	private static final String SEARCH_RESULTS = "[{\"title\": \"Paris\",\"location_type\": \"City\",\"woeid\": 615702,\"latt_long\": \"48.856930,2.341200\"}]";
	

}
