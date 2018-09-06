package de.telran.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
public class ClientSideTestsWithMockRestService {

    RestTemplate restTemplate = new RestTemplate();

    private MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

    @Test
    public void testHelloWorld() {
        server.expect(once(), requestTo("/api")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("Hello World!", MediaType.APPLICATION_JSON));

        String result = restTemplate.getForObject("/api", String.class, "Hello World!");

        assertTrue("Hello World!".equals(result));

    }
}
