
public class CountThread implements Runnable {

    Counter counter;
    boolean inc;

    public CountThread(Counter c, boolean inc) {
        this.counter = c;
        this.inc = inc;
    }

    public void run () {
        for(int i = 0; i<1000; i++) {
            if (inc) {
                counter.increment();
                System.out.println("incrementing "+counter.value());
            } else {
                counter.decrement();
                System.out.println("decrementing "+counter.value());
            }
        }
    }
}
