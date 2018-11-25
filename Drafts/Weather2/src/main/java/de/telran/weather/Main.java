package de.telran.weather;

public class Main {

    public static void main(String [] args) throws Exception {
        WeatherForecaster wh = new WeatherForecaster(new DataSource());
        SearchResult berlin = wh.findLocationByCityName("berlin");
        System.out.println(berlin);
    }

}
