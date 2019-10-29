package de.telran.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        Philosopher[] philosophers = new Philosopher[5];
        try {

            Fork[] forks = new Fork[philosophers.length];

            for (int i = 0; i < forks.length; i++) {
                forks[i] = new Fork(i);
            }

            service = Executors.newFixedThreadPool(philosophers.length);

            for (int i = 0; i < philosophers.length; i++) {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % forks.length]);
                service.execute(philosophers[i]);
            }

            Thread.sleep(5000);
            for (Philosopher philosoper : philosophers) {
                philosoper.isFull = true;
            }

        } finally {
            service.shutdown();
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);

            //check whether they all have eaten something
            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher + " no of eats: "
                        + philosopher.getNumberOfEats());
            }
        }
    }
}
