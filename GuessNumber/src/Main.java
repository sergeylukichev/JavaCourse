public class Main {

    public static void main(String[] args) {
        GuessNumberGame game = new GuessNumberGame(15,
                3,
                new KeyboardGuess(),
                new ConsoleOutput());

        game.play();
    }


}
