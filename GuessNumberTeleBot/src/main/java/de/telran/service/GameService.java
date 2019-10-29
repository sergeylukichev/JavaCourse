package de.telran.service;


import de.telran.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GuessNumberGame game;

    @Autowired
    private GuessSource source;

    @Autowired
    private ResultOutput output;

    public GameService() {}

    public void processGameRequest(String message) throws Exception {
        if(game.isRunning()) {
            setGuessNumber(Integer.valueOf(message));
        } else {
            restartTheGame();
        }
    }

    public String readOutput() throws Exception {
        return output.getOutput();
    }

    private void setGuessNumber(int number) {
        source.setGuessedNumber(number);
    }

    private void restartTheGame() {
        game.setAttemptsCount(GuessNumberGame.ATTEMPT_COUNT_DEFAULT);
        Thread t = new Thread(game);
        t.start();
    }
}
