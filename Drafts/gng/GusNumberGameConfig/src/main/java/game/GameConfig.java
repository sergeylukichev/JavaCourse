package game;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("game")
public class GameConfig {

    @Bean
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    //@Scope("prototype")
    public GuessSource getGuessSource() {
        return new KeyboardGuess();
    }

    @Bean
    public ResultOutput getResultOutput() {
        return new ConsoleOutput();
    }

    @Bean
    public GuessNumberGame game(GuessSource source, ResultOutput output) {
        return new GuessNumberGame(source, output);
    }
}
