package de.telran.controller;

import de.telran.exception.CityNotFoundException;
import de.telran.model.CityWeather;
import de.telran.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService service;

    @Test
    public void testGetCityWeather() throws Exception {

        when(service.getWeatherByCityName("berlin"))
                .thenReturn(new CityWeather("Berlin", 22.4));

        mvc.perform(get("/weather/berlin")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())//good for simple debugging
                .andExpect(jsonPath("$.city").value("Berlin"))
                .andExpect(jsonPath("$.temp").value("22.4"));
    }

    @Test
    public void testCityNotFound() throws Exception {
        when(service.getWeatherByCityName("acdef"))
                .thenThrow(CityNotFoundException.class);

        mvc.perform(get("/weather/acdef")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }



}
