package de.telran.model;

public class GuessNumberGame implements Runnable {

    public static int ATTEMPT_COUNT_DEFAULT = 3;

    private int secretNumber;
    private int attemptsCount;
    private GuessSource guessSource;
    private ResultOutput output;

    private boolean isRunning = false;

    public GuessNumberGame(int secretNumber,
                           GuessSource source,
                           ResultOutput output) {
        this.secretNumber = secretNumber;
        this.attemptsCount = ATTEMPT_COUNT_DEFAULT;
        this.guessSource = source;
        this.output = output;
    }

    public void play() throws Exception {
        System.out.println("Starting a new game");
        showGreetings();
        boolean guessedCorrectly = tryToGuess();
        showGameOver(guessedCorrectly);
    }

    private boolean tryToGuess() throws Exception {
        boolean guessedCorrectly = false;
        while(attemptsCount > 0 && !guessedCorrectly) {
            showTryAgain();
            int number = guess();
            if(number == secretNumber) {
                guessedCorrectly = true;
            }
            attemptsCount--;
        }
        return guessedCorrectly;
    }


    private void showGreetings() {
        output.output("Welcome to the guess number game!");
    }

    private void showTryAgain () {
        output.output("Enter your number:");
    }

    private void showGameOver(boolean guessedCorrectly) {
        if(guessedCorrectly) {
            output.output("Congratulation, you won!");
        } else {
            output.output("You lose!");
        }
    }

    private int guess() throws Exception {
        System.out.println("waiting for a guess");
        return guessSource.guess();
    }

    public void run() {
        isRunning = true;
        try {
            play();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            isRunning = false;
        }
    }

    public void setAttemptsCount(int attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
