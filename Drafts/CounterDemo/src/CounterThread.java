public class CounterThread implements Runnable{

    Counter counter;
    boolean inc;

    public CounterThread(Counter counter, boolean inc) {
        this.counter = counter;
        this.inc = inc;
    }

    @Override
    public void run() {
        for(int i = 0; i< 1000; i++) {
            if(inc) {
                counter.inc();
            } else {
                counter.dec();
            }
        }
    }
}
