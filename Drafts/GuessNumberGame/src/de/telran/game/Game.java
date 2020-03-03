package de.telran.game;

import java.util.Scanner;

public class Game {

    private int numberOfAttempts;
    private int secret;

    private NumberSource source;
    private ResultOutput output;

    public static void main(String[] args) {
        NumberSource s = new NumberSource() {
            private Scanner s = new Scanner(System.in);
            @Override
            public int getNumber() {
                return s.nextInt();
            }
        };

        ResultOutput out = System.out::println;
        Game game = new Game(3, 5, s, out);
        game.play();
    }

    public Game(int numberOfAttempts,
                int secret,
                NumberSource source,
                ResultOutput output
                ) {
        this.numberOfAttempts = numberOfAttempts;
        this.secret = secret;
        this.source = source;
        this.output = output;

    }

    public void play() {
        print("Welcome!");
        boolean result = guessNumber();
        if (result) {
            print("Congrats, you won!");
        } else {
            print("You lost!");
        }
    }

    private boolean guessNumber() {
        while(numberOfAttempts != 0) {
            print("number: ");
            int number = getNumber();
            if (number == secret) {
                return true;
            }
            numberOfAttempts--;
        }
        return false;
    }

    private void print(String s) {
        output.print(s);
    }

    private int getNumber() {
        return source.getNumber();
    }
}
