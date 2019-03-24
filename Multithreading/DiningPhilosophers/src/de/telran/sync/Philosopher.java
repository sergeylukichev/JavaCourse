package de.telran.sync;

import java.util.Random;

public class Philosopher implements Runnable {
    private Object leftFork;
    private Object rightFork;

    private Random random = new Random();

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run() {
        try {
            while(true) {
                doAction("thinking");
                synchronized (leftFork) {
                    doAction("picked up left fork");
                    synchronized (rightFork) {
                        doAction("picked up right fork");
                        doAction("eating");
                        doAction("put down right fork");
                    }
                    doAction("put down left fork");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(random.nextInt(1000));
    }
}
