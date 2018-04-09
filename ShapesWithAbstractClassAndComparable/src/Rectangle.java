
public class Rectangle extends Shape {
	
	private double a;
	private double b;
	
	public Rectangle (String displayName, double a, double b) {
		super(displayName);
		this.a = a;
		this.b = b;
	}
	
	public double getArea() {
		return a*b;
	}

}
