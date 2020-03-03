public class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (msg) {
            try {
                System.out.println(name + " waiting for notify");
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " notified");
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}
