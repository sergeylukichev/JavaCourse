package de.telran.demo.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import de.telran.demo.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonRepositoryConfig {

    @Bean
    public PersonRepository getPersonRepository() {
        return new PersonRepository();
    }

}
