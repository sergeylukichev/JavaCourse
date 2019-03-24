package de.telran.reentrant;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lane {

    Lock lock = new ReentrantLock();

    private static int NUMBER_OF_BOXES = 10;

    private static int MAX_SIZE = 3;

    private static Lane INSTANCE = new Lane();

    private LinkedList<IntBox> items = new LinkedList<>();

    public boolean addToLane(IntBox box) throws InterruptedException {
        print("   items on Lane " + items.size());
        print("   trying to add box "+box);
        boolean ret = false;

        if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
            if (items.size() < MAX_SIZE) {
                items.add(box);
                print("   added.  items on Lane " + items.size());
                ret = true;
            } else {
                System.out.println("   not added " + box);
                Thread.sleep(300);
            }
            lock.unlock();
        }


        return ret;

    }

    public void removeFromLane(IntBox box) {
        System.out.println(items.remove(box));
        print("removing item " + box);
        print("   items on Lane " + items.size());
    }

    private Lane() {}

    public static Lane getInstance() {
        return INSTANCE;
    }

    public void print(String s) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " "+s);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_BOXES);
        try {
            for(int i = 0; i < NUMBER_OF_BOXES; i++) {
                IntBox box = new IntBox(i);
                service.execute(box);
            }
        } finally {
            Thread.sleep(5000);
            service.shutdown();

            // Wait for all thread to finish
            while (!service.isTerminated()) {
                Thread.sleep(1000);
            }
        }

        }

}
