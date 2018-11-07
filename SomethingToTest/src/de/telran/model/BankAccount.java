package de.telran.model;

public class BankAccount {

	String IBANN;
	Person owner;
	public BankAccount(String iBANN, Person owner) {
		super();
		IBANN = iBANN;
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "BankAccount [IBANN=" + IBANN + ", owner=" + owner + "]";
	}
	public String getIBANN() {
		return IBANN;
	}
	public void setIBANN(String iBANN) {
		IBANN = iBANN;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	
}
