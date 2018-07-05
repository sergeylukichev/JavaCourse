package telran.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

public class DataSource {

	private static final String SEARCH_URL = "https://www.metaweather.com/api/location/search";
	private static final String QUERY_PARAM = "query";
	private static final String FORECAST_URL = "https://www.metaweather.com/api/location/";
	
	private URL searchUrl;
	
	public DataSource() {
		
	}
	
	public Optional<String> readSearchResults(String param) throws Exception {
		searchUrl = new URL(SEARCH_URL+"?"+QUERY_PARAM+"="+param);
		URLConnection conn = searchUrl.openConnection();
		return readFromInputStream(conn.getInputStream());
	}
	
	public Optional<String> readForecast(String woeid) throws Exception {
		URL url = new URL(FORECAST_URL+woeid);
		URLConnection conn = url.openConnection();
		return readFromInputStream(conn.getInputStream());
	}
	
	private Optional<String> readFromInputStream(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		return reader.lines().reduce((a, b) -> a+b);		
	}
	
}
