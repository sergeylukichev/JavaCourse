package de.telran.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class PersonConfiguration {

	//@Bean
	public PersonService personService() {
		return new PersonService();
	}
}
