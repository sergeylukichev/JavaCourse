package de.telran.config;

import de.telran.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class GameServiceConfiguration {

    @Bean
    public GuessSource createGuessSource() {
        return new QueuedSource();
    }

    @Bean
    public ResultOutput createResultOutput() {
        return new QueuedOutput();
    }

    @Bean
    public GuessNumberGame createGame(GuessSource source, ResultOutput output) {
        return new GuessNumberGame(3, source, output);
    }
}
