
public class Address {

	String street;
	Integer houseNumber;
	public Address(String street, Integer houseNumber) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", houseNumber=" + houseNumber + "]";
	}
	
	
}
