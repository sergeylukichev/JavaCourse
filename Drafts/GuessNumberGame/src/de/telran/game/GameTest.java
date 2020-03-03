package de.telran.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testOneAttemptHappyCase() {
        int attempts = 1;
        int secret = 5;
        NumberSource s = () -> 5;
        TestOutput out = new TestOutput();

        String expected = "Congrats, you won!";

        Game game = new Game(attempts, secret, s, out);
        game.play();

        String actual = out.value;

        assertEquals(expected, actual);
    }
}
