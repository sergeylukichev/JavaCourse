import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
	
		List<Thread> planes = Arrays.asList(
				new Thread(new Plane("Boing 747")),
				new Thread(new Plane("Airbus 320")),
				new Thread(new Plane("Il 86")));
		
		planes.forEach(Thread::start);
	}
}
