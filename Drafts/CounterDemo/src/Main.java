public class Main {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        CounterThread c1 = new CounterThread(c, true);
        CounterThread c2 = new CounterThread(c, false);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getCounter());

    }
}
