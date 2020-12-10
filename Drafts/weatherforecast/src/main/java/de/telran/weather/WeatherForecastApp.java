package de.telran.weather;

import de.telran.weather.service.InputOutputService;
import de.telran.weather.service.WeatherService;

public class WeatherForecastApp {
    private InputOutputService inputOutputService;
    private WeatherService service;

    public WeatherForecastApp(InputOutputService inputOutputService, WeatherService service) {
        this.inputOutputService = inputOutputService;
        this.service = service;
    }

    public void execute() throws Exception {
        String s = inputOutputService.readValue();
        String result = service.getWeatherByCityName(s);
        inputOutputService.print(result);
    }

    public static void main(String[] args) {

    }
}
