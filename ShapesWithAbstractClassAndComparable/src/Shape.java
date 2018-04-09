
public abstract class Shape implements Comparable<Shape>{
	private String displayName;
	
	public Shape(String displayName) {
		this.displayName = displayName;
	}
	
	public abstract double getArea();
	
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public int compareTo(Shape o) {
		if(getArea() - o.getArea()>0) {
			return 1;
		} else if (getArea() - o.getArea()<0) {
			return -1;
		} else return 0;		
	}
}
