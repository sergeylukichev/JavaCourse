package de.telran.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.demo.client.HelloWorldClient;
import de.telran.demo.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(HelloWorldClient.class)
public class ClientSideTestsWithRestClientTest {

    @Autowired
    private HelloWorldClient client;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        String personString = objectMapper.writeValueAsString(new Person("Sergey", "Lukichev", 40));
        System.out.println(personString);
        server.expect(requestTo("/api/persons/0"))
                .andRespond(withSuccess(personString, MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetById() throws Exception {
        Person person = client.getPersonById(0);
        System.out.println(person);
        assertTrue(person.getFirstName().equals("Sergey"));
        assertTrue(person.getLastName().equals("Lukichev"));
    }
}
