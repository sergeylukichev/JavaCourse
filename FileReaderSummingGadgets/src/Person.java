
public class Person {

	String firstName;
	String lastName;
	Gadget gadget;
	public Person(String firstName, String lastName, Gadget gadget) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gadget = gadget;
	}
	
	public Gadget getGadget() {
		return gadget;
	}
	
	public String getFullName() {
		return firstName+lastName;
	}
}
