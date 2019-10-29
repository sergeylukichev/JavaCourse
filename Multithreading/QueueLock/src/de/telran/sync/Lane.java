package de.telran.sync;

import java.util.LinkedList;
import java.util.List;

public class Lane {

    private static int MAX_SIZE = 3;

    private static Lane INSTANCE = new Lane();

    private List<IntBox> items = new LinkedList<>();

    public synchronized void addToLane(IntBox box) throws InterruptedException {
        print("   items on Lane " + items.size());
        if (items.size() < MAX_SIZE) {
            items.add(box);
            box.hasStarted = true;
            print("     items on Lane " + items.size());
        } else {
            wait();
        }
    }

    public synchronized void removeFromLane(IntBox box) {
        items.remove(box);
        notifyAll();
        print("removing item " + box);
        print("   items on Lane " + items.size());
    }

    public static Lane getInstance() {
        return INSTANCE;
    }

    public void print(String s) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " "+s);
    }
    private Lane() {}

    public static void main(String[] args) {
        for(int i = 0; i< 100; i++) {
            new Thread(new IntBox(i)).start();
        }
    }
}
