package telran.hotcities.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor{

	private static Logger LOG = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);
	@Override
	public ClientHttpResponse intercept(HttpRequest request, 
			byte[] body, 
			ClientHttpRequestExecution execution)
			throws IOException {
		
		logRequest(request);
		
		ClientHttpResponse execute = execution.execute(request, body);
		
		logResponse(execute);
		return execute;
	}
	
	private void logRequest(HttpRequest request) {
		LOG.info("Request Headers {}", request.getHeaders());
		LOG.info("Request Method {}", request.getMethodValue());
	}
	
	private void logResponse(ClientHttpResponse response) throws IOException {
		LOG.info("Response Body: {}", readResponseBody(response));
		LOG.info("Response Status: {}", response.getStatusText());
	}
	
	private String readResponseBody(ClientHttpResponse response) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()));
		return reader.lines().reduce((a, b) -> a + b).orElse("empty body");
	}

}
