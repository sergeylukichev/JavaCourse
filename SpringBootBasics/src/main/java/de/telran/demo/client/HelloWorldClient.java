package de.telran.demo.client;

import de.telran.demo.model.Person;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldClient {

    private final RestTemplate restTemplate;

    public HelloWorldClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Person getPersonById(int id) {
        return restTemplate.getForObject("/api/persons/{id}", Person.class, id);
    }
}
