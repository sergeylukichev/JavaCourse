
public class Plane implements Runnable {
	
	String name;
	
	public Plane(String name) {
		this.name = name;
	}
	
	public void run() {	
		Lane lane = Lane.getInstance();
		synchronized(lane) {
			lane.use(name);
			System.out.println(name + " fly away!");	
		}
	}
}
