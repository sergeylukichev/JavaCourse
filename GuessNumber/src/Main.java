public class Main {

    public static void main(String[] args) {

        KeyboardGuess source = new KeyboardGuess();
        ConsoleOutput output = new ConsoleOutput();
        int secretNumber = 15;
        int attemptsCount = 3;

        GuessNumberGame game = new GuessNumberGame(
                secretNumber,
                attemptsCount,
                source,
                output);

        game.play();
    }


}
