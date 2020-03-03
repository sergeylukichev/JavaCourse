import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class WeatherDemo {
    public static void main(String[] args) throws Exception {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=berlin&units=metric&appid=73fbf39242ea500a37b2b5a6c74099a4";

        ObjectMapper mapper = new ObjectMapper();

        Object s = mapper.readValue(new URL(urlString), Object.class);

        System.out.println(s);

    }
}
