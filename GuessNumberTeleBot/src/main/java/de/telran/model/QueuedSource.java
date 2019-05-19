package de.telran.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueuedSource implements GuessSource {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    @Override
    public int guess() throws Exception {
            return queue.take();
    }

    @Override
    public void setGuessedNumber(Integer number) {
        queue.add(number);
    }
}
