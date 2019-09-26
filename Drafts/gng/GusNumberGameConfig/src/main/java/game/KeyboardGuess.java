package game;

import java.util.Scanner;

public class KeyboardGuess implements GuessSource {
    private int counter = 0;
    Scanner scanner = new Scanner(System.in);
    @Override
    public int guess() {
        return scanner.nextInt();
    }

    @Override
    public String toString() {
        return "KeyboardGuess{" +
                "counter=" + ++counter +
                "'";
    }
}
