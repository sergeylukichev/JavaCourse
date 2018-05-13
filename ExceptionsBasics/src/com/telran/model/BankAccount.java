package com.telran.model;

public class BankAccount {
	String iban;

	public BankAccount(String iban) {
		super();
		this.iban = iban;
	}
	
	public String getIban() {
		return iban;
	}

	@Override
	public String toString() {
		return "BankAccount [iban=" + iban + "]";
	}
	
	

}
