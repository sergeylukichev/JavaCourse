package de.telran.sync;

public class Main {

    public static void main(String[] args) {

        //Dining philosophers with synchronized
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for(int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for(int i = 0; i< philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i +1) % forks.length];

            //the last philisopher picks up forks in opposite orders to the others, therefore, no deadlock happens
            //note, that for other similar problems (threads competing for more than one resource), changing the order might not be possible.
            if(i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }


            new Thread(philosophers[i], "Philosopher "+ (i + 1)).start();
        }
    }


}
