
public class Counter {
	
	private int c = 0;
	
	public synchronized void increment () {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}
	
	public int value() {
		return c;
	}
}
