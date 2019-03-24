package de.telran.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

    Lock up = new ReentrantLock();
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    public boolean pickUp(Philosopher who, String hand) throws InterruptedException {
        if(up.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(who + " picked up " + hand + this);
            return true;
        } else {
            return false;
        }
    }

    public void putDown(Philosopher who, String hand) {
        up.unlock();
        System.out.println(who + " put down " + hand + this);
    }

    @Override
    public String toString() {
        return "Fork " +id;
    }
}
