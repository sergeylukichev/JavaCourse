import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GuessNumberGame {

    @Value("15") // Error:java: javacTask: source release 8 requires target release 1.8 - везде Java 8 стоит
    private int secretNumber;
    @Value("3")
    private int attemptsCount;
    private GuessSource guessSource;
    private ResultOutput output;

    @Autowired
    public GuessNumberGame(int secretNumber,
                           int attemptsCount,
                           GuessSource source,
                           ResultOutput output) {
        this.secretNumber = secretNumber;
        this.attemptsCount = attemptsCount;
        this.guessSource = source;
        this.output = output;
    }

    public void play() {
        showGreetings();
        boolean guessedCorrectly = tryToGuess();
        showGameOver(guessedCorrectly);
    }

    private boolean tryToGuess() {
        boolean guessedCorrectly = false;
        while(attemptsCount > 0 && !guessedCorrectly) {
            int number = guess();
            if(number == secretNumber) {
                guessedCorrectly = true;
            } else {
                showTryAgain();
            }
            attemptsCount--;
        }
        return guessedCorrectly;
    }


    private void showGreetings() {
        output.output("Enter your number: ");
    }

    private void showTryAgain () {
        output.output("Try again");
    }

    private void showGameOver(boolean guessedCorrectly) {
        if(guessedCorrectly) {
            output.output("Congratulation, you won!");
        } else {
            output.output("You lose!");
        }
    }

    private int guess() {
        return guessSource.guess();
    }
}
