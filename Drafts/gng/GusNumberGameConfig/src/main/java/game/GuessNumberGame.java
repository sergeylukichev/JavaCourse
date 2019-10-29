package game;

public class GuessNumberGame {

    private int secretNumber = 15;
    private int attemptsCount = 3;
    private GuessSource guessSource;
    private ResultOutput output;

    public GuessNumberGame(GuessSource source,
                           ResultOutput output) {
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
