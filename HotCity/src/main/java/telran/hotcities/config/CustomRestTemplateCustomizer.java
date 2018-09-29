package telran.hotcities.config;

import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class CustomRestTemplateCustomizer implements RestTemplateCustomizer{

	private static Logger LOG = LoggerFactory.getLogger(CustomRestTemplateCustomizer.class);
	/*
	 * Note that we use BufferingClientHttpRequestFactory in order to cash request/response body 
	 * so that we could "read" it twice: once for logging, second for the client
	 * 
	 */
	@Override
	public void customize(RestTemplate restTemplate) {
		restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(getRequestFactory()));
	}
	
	private ClientHttpRequestFactory getRequestFactory() {
		HttpComponentsClientHttpRequestFactory requestFactory =
				new HttpComponentsClientHttpRequestFactory();
		try {
			TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
	
			SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
					.loadTrustMaterial(null, acceptingTrustStrategy)
					.build();
	
			SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
	
			CloseableHttpClient httpClient = HttpClients.custom()
					.setSSLSocketFactory(csf)
					.build();
	
	
			requestFactory.setHttpClient(httpClient);
		} catch (Exception ex) {
			//ideally we should stop loading the app when it happens
			LOG.info("Could not customize http client for the request factory: ", ex);
		}
		return requestFactory;
	}

}
