package de.telran.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueuedOutput implements ResultOutput {

    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    @Override
    public void output(String result) {
        queue.add(result);
    }

    public String getOutput() throws Exception {
        return queue.take();
    }
}
