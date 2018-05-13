package com.telran.model;

public class Customer {
	String name;
	int age;
	BankAccount bankAccount;
	public Customer(String name, int age, BankAccount bankAccount) {
		super();
		this.name = name;
		this.age = age;
		this.bankAccount = bankAccount;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", bankAccount=" + bankAccount + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}

}
