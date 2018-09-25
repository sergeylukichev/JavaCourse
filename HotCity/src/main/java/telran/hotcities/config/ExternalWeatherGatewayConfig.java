package telran.hotcities.config;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import telran.hotcities.gateway.ExternalWeatherGateway;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@Configuration
public class ExternalWeatherGatewayConfig {
	
	@Bean
	public ExternalWeatherGateway getWeatherGateway() throws Exception {
		return new ExternalWeatherGateway("https://www.metaweather.com/api/location/search",
		"https://www.metaweather.com/api/location/",
		getRestTemplate());
	}
	
	@Bean
	public RestTemplate getRestTemplate() throws Exception {
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
				.loadTrustMaterial(null, acceptingTrustStrategy)
				.build();

		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom()
				.setSSLSocketFactory(csf)
				.build();

		HttpComponentsClientHttpRequestFactory requestFactory =
				new HttpComponentsClientHttpRequestFactory();

		requestFactory.setHttpClient(httpClient);

		RestTemplate rest = new RestTemplate(requestFactory);
		return rest;
	}

}
