package de.telran.model;

import java.util.Scanner;

public class KeyboardGuess implements GuessSource {
    Scanner scanner = new Scanner(System.in);
    @Override
    public int guess() {
        return scanner.nextInt();
    }

    @Override
    public void setGuessedNumber(Integer number) {

    }


}
