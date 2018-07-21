package de.telran.gateway;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHanlder implements ResponseErrorHandler {

  @Override
  public boolean hasError(ClientHttpResponse httpResponse) 
    throws IOException {

      return (
        httpResponse.getStatusCode().series() == Series.CLIENT_ERROR 
        || httpResponse.getStatusCode().series() == Series.SERVER_ERROR);
  }

  @Override
  public void handleError(ClientHttpResponse httpResponse) 
    throws IOException {

      if (httpResponse.getStatusCode()
        .series() == HttpStatus.Series.SERVER_ERROR) {
          System.out.println("Server error occured");
      } else if (httpResponse.getStatusCode()
        .series() == HttpStatus.Series.CLIENT_ERROR) {
          System.out.println("Not found");;
      }
  }
}
