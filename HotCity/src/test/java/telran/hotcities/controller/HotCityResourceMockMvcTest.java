package telran.hotcities.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import telran.hotcities.exception.SomeCitiesNotFoundException;
import telran.hotcities.model.HottestCity;
import telran.hotcities.service.WeatherService;

/*
 * Unit test with dependency mocked.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HotCityResource.class)
public class HotCityResourceMockMvcTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private WeatherService service;
	
	@Test
	public void testHotCity() throws Exception {
		String [] cities = {"paris","berlin"};
		
		when(service.getHottestCity(cities))
		.thenReturn(new HottestCity("Berlin", "22.4"));
		
		mvc.perform(get("/api/weather/paris,berlin")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())//good for simple debugging
				.andExpect(jsonPath("$.name").value("Berlin"))
				.andExpect(jsonPath("$.temp").value("22.4"));	
	}

	@Test
	public void testHotCityNotFound() throws Exception {
		String [] cities = {"abrambra"};
		
		when(service.getHottestCity(cities))
		.thenThrow(new SomeCitiesNotFoundException("not found"));
		
		mvc.perform(get("/api/weather/abrambra")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andDo(print());	
	}
}
