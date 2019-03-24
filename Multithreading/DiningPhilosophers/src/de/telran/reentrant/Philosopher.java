package de.telran.reentrant;

import java.util.Random;

public class Philosopher implements Runnable {

    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private int numberOfEats = 0;

    volatile boolean isFull = false;
    private Random random = new Random();

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try{
            while (!isFull) {
                doAction("thinking");
                if(leftFork.pickUp(this, "left")) {
                    if(rightFork.pickUp(this, "right")) {
                        doAction("eating");
                        numberOfEats ++;
                        rightFork.putDown(this, "right");
                    }
                    leftFork.putDown(this, "left");
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(random.nextInt(1000));
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    public int getNumberOfEats() {
        return numberOfEats;
    }
}
