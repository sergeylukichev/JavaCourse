package com.telran;

import java.util.Arrays;
import java.util.List;

import com.telran.exceptions.BankCountryMissmatchException;
import com.telran.exceptions.InvalidAgeException;
import com.telran.exceptions.InvalidIBANLengthException;
import com.telran.model.BankAccount;
import com.telran.model.Customer;

public class Main {
	
	public static void main(String[] args) {
		
		List<Customer> customers = Arrays.asList(
				new Customer("Ivan", 15, new BankAccount("DE12121212121212")),
				new Customer("Piotr", 19, new BankAccount("DE1212121212121")),
				new Customer("Maria", 27, new BankAccount("DE12121212121212")),
				new Customer("Svetlana", 30, new BankAccount("DE12166121212")),
				new Customer("Elena", 15, new BankAccount("ES1212121212121"))
				);	
		
		//Homework: improve validateCustomers() method so that it returns Map<String, List<String>>, 
		//where String key is the customer's name and List<String> is a list of
		//error messages, related to the customer. 
		
		validateCustomers(customers);
	}
	
	public static void validateCustomers(List<Customer> customers) {
		for (Customer customer:customers){	
			System.out.printf("Validating customer %s%n", customer.getName());
			validateCustomer(customer);
		}
	}
	
	public static void validateCustomer(Customer customer){
	
		validateBankAccount(customer.getBankAccount());
		
		try {
			validateCustomerAge(customer.getAge());
		} catch (InvalidAgeException ex) {
			System.out.printf("    Invalid age %d for customer %s%n", customer.getAge(), customer.getName());
		}
	}
	
	public static void validateCustomerAge(int age)  throws InvalidAgeException {
		if(age<17) {
			throw new InvalidAgeException(String.format("Invalid age %d", age));
		}
	}
	
	public static void validateBankAccount(BankAccount account) {
		try {
			validateBankAccountCountry(account.getIban());	
		} catch (BankCountryMissmatchException ex) {
			System.out.printf("    Bank account country is not valid %s%n", ex.getMessage());
		}
		
		try {
			validateIbanLength(account.getIban());	
		} catch (InvalidIBANLengthException ex) {
			System.out.printf("    Invalid iban length %s%n", ex.getMessage());
		}
	}
	
	public static void validateIbanLength(String iban) throws InvalidIBANLengthException {
		int length = iban.length();
		if(length != 16) {
			throw new InvalidIBANLengthException(String.format("Invalid iban length %d", length));
		}
	}
	
	public static void validateBankAccountCountry(String iban) throws BankCountryMissmatchException{
		String country = iban.substring(0, 2);
		if(!country.equals("DE")) {
			throw new BankCountryMissmatchException(String.format("Invalid iban country %s", country));
		}
	}
}
