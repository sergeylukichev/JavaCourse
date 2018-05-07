import java.util.List;

public class Person {
	String name;
	Integer age;
	Address address;
	
	List<BankAccount> bankAccounts;
	
	public Person(String name, Integer age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public Person(String name, Integer age, Address address, List<BankAccount> bankAccounts) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		
		this.bankAccounts = bankAccounts;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
}
