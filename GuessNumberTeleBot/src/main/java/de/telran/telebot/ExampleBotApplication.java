package de.telran.telebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.telran")
public class ExampleBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleBotApplication.class, args);
	}

}
