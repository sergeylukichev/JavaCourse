package telran.hotcities.model;

public class HottestCity {
	String name;
	String temp;
	
	/*
	 * added for jackson, when the class is used on the client side. 
	 * The proper way would be to create another class for handle client-side deserialization.
	 */
	public HottestCity() {}
	
	public HottestCity(String name, String temp) {
		this.name = name;
		this.temp = temp;
	}
	
	public HottestCity(String name, double temp) {
		this.name = name;
		this.temp = String.valueOf(temp);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
}
