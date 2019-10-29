package de.telran.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

	private static Logger LOG = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);
	@Override
	public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution)
			throws IOException {
		logRequest(request);
		ClientHttpResponse execute = execution.execute(request, body);
		return logResponse(execute);
	}
	
	private void logRequest(HttpRequest request) {
		LOG.info("Request Headers {}", request.getHeaders());
		LOG.info("Request Method {}", request.getMethodValue());
	}
	
	private ClientHttpResponse logResponse(ClientHttpResponse response) throws IOException {
        final ClientHttpResponse responseCopy = new BufferingClientHttpResponseWrapper(response);
        LOG.info("Response Body: {}", readResponseBody(responseCopy.getBody()));
		LOG.info("Response Status: {}", response.getStatusText());
		return responseCopy;
	}
	
	private String readResponseBody(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		return reader.lines().reduce((a, b) -> a + b).orElse("empty body");
	}
}