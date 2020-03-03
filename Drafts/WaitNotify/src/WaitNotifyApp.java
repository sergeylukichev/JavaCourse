public class WaitNotifyApp {

    public static void main(String[] args) {
        Message msg = new Message("");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter, "waiter").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        System.out.println("Everything has been started");
    }
}
