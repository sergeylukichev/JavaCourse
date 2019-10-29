package de.telran.sync;

public class IntBox implements Runnable{
    int i = 0;
    private Lane lane = Lane.getInstance();

    public boolean hasStarted = false;

    public IntBox(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            while (!hasStarted) {
                lane.addToLane(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Starting box for " + i);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lane.removeFromLane(this);

    }

    @Override
    public String toString() {
        return "IntBox{" +
                "i=" + i +
                '}';
    }
}
