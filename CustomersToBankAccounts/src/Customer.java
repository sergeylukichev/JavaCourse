
public class Customer {

	String fname;
	String lname;
	public Customer(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Customer [fname=" + fname + ", lname=" + lname + "]";
	}
	
	
}
