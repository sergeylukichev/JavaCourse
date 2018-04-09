
public class Square extends Shape{
	private double a;
	public Square(String displayName, double a) {
		super(displayName);
		this.a = a;
	}
	
	public double getArea() {
		return a*a;
	}
}
