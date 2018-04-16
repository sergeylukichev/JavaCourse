
public class BankAccount {

	String ibann;
	String bic;
	Customer customer;
	public BankAccount(String ibann, String bic, Customer customer) {
		super();
		this.ibann = ibann;
		this.bic = bic;
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "BankAccount [ibann=" + ibann + ", bic=" + bic + "]";
	}
	
	
}
