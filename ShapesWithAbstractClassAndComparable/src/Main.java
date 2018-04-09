import java.util.Arrays;

public class Main {
	public static void main(String [] args) {
		Shape circle = new Circle("Circle", 10);
		
		Shape rectangle = new Rectangle("Rectangle", 5, 10);
		
		Shape shape = new Square("Square", 7);
	
		Shape [] shapes = {circle, rectangle, shape};
		
		Arrays.sort(shapes);
		
		System.out.println("Sorted shapes: ");
		for(Shape s: shapes) {
			System.out.println(s.getDisplayName()+" has area of "+s.getArea());
		}		
	}

}
