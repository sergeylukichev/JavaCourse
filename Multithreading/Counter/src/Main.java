
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		Thread thread1 = new Thread(new CountThread(c, true));				
		Thread thread2 = new Thread(new CountThread(c, false));

		thread2.start();
		thread1.start();

		thread1.join();
		thread2.join();
		
		//Thread.sleep(1000);
		System.out.println("final count "+c.value());
	}
}
