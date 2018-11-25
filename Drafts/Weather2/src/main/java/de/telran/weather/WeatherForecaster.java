package de.telran.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class WeatherForecaster {

    DataSource source;
    public WeatherForecaster(DataSource source) {
      this.source = source;
    }

    public SearchResult findLocationByCityName(String city) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Optional<String> searchResultString = source.readSearchResults(city);

        SearchResult[] searchResults = mapper.readValue(searchResultString.get(), SearchResult[].class);
        return searchResults[0];
    }

}
