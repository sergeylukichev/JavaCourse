import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfig {

    @Bean
    public KeyboardGuess getkeyboardGuess() {
        return new KeyboardGuess();
    }

    @Bean
    public ConsoleOutput getconsoleOutput() {
        return new ConsoleOutput();
    }

    @Bean
    public GuessNumberGame getguessNumberGame(KeyboardGuess keyboardGuess, ConsoleOutput consoleOutput) {
        return new GuessNumberGame(15, 3, keyboardGuess, consoleOutput);
    }


}
