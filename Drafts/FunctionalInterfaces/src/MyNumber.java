
public class MyNumber implements Comparable<MyNumber> {
	
	private int number;
	private String name;
	
	public MyNumber(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}

	public int compareTo(MyNumber o) {
		if(number>o.getNumber()) {
			return 1;
		} else if(number < o.getNumber()) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return Integer.toString(number)+ " " + name;
	}

}
