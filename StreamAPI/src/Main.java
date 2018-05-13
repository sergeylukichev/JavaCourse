import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Address a1 = new Address("Freidrichstrasse", 17);
		Address a2 = new Address("Calvinstrsse", 13);
		Address a3 = new Address("Unter den Linden", 1);
		Address a4 = new Address("Kurfuerstendamm", 22);
		
		Person p1 = new Person("Piotr", 12, a1);
		Person p2 = new Person("Ivan", 18, a2);
		Person p3 = new Person("John", 22, a3);
		Person p4 = new Person("Johanna", 12, a4);
		Person p5 = new Person("Maxim", 40, a1);
		
		BankAccount b1 = new BankAccount("DE123123", p1);
		BankAccount b2 = new BankAccount("ES123123", p1);
		BankAccount b3 = new BankAccount("NL555555", p2);
		BankAccount b4 = new BankAccount("RO789887", p2);
		
		//Get addresses of persons, older than age of 17 
						
		List<Address> addresses = getAddresses(Arrays.asList(p1, p2, p3, p4, p5));
		
		System.out.println("Addresses more than 17 "+addresses);
		
		
		//Given a a list of names as a string. Return a string with no duplicate names. 
		
		String names = "Piotr Ivan Piotr Johanna Ivan John";
		
		String noDuplicateNames = noDuplicateNames(names);
		
		System.out.println("No Duplicate Names "+noDuplicateNames);
		
		//Given a list of persons with age, return a map where the key is age and the value is the list of persons of that age
		
		Map<Integer, List<Person>> personsByAge = getPersonsByAge(Arrays.asList(p1, p2, p3, p4, p5));
		
		System.out.println("Persons by age "+personsByAge);
		
		//For a given list of bank accounts, each refers to a person, return a map, where the key is the person and the value is the list of his bank accounts
		
		Map<Person, List<BankAccount>> bankAccountsByCustomer = getBankAccountsByCustomer(Arrays.asList(b1, b2, b3, b4));

		bankAccountsByCustomer.forEach((k, v) -> System.out.println(k+" "+v));
		
		//For a given list of bank accounts, return a list of string ibanns where characters from position 3 are allianated (replaced with *)
		
		System.out.println("Allianated ibanns "+allianateBankAccounts((Arrays.asList(b1, b2, b3, b4))));
		
		//Count a number of words in a given sentence, which start with a given character
		
		String sentence = "if you are the dealer I am out of the game";
		System.out.println("Words start with 'i': "+countWordsByCharacter(sentence, "i"));
		
		//Given a string. Check whether it is a number.
		
		String isNumber = "123123123123123435346543569465";
		System.out.println("Is "+isNumber+" a number? "+isNumber(isNumber));
		String isNumber2 = "123asdlfkjsdhksj43569465";
		System.out.println("Is "+isNumber2+" a number? "+isNumber(isNumber2));
		
		//for a given list of persons, each has a list of bank accounts, return a list of allienated ibanns
		
		Person person1 =new Person("Piotr", 12, a1, Arrays.asList(b1, b2));		
		Person person2 = new Person("Ivan", 18, a2, Arrays.asList(b3, b4));
		
		System.out.println("Allienated ibanns "+getIbannsForCustomers(Arrays.asList(person1, person2)));
		
		//Sum up the age of persons who are older than 17
		
		System.out.println("Total age "+sumAge(Arrays.asList(p1, p2, p3, p4, p5)));
		
		
		//Join person names of age more than 17
		
		System.out.println(ofLegalAge(Arrays.asList(p1, p2, p3, p4, p5)));
		
	}
	
	public static String noDuplicateNames(String names) {
		List<String> namesList = Arrays.asList(names.split(" "));
		return namesList.stream().collect(Collectors.toSet()).toString();
	}
	
	public static List<Address> getAddresses(List<Person> persons) {
		return persons.stream().filter(p -> p.age > 17).map(p -> p.address).collect(Collectors.toList());
	}
	
	public static int sumAge(List<Person> persons) {

		return persons.stream()
				.filter(p -> p.age > 17)
				.reduce(0, (a, b) -> a + b.getAge(), (a, b) -> a + b);
		
	}
	
	public static Map<Person, List<BankAccount>> getBankAccountsByCustomer(List<BankAccount> bankAccounts) {
		
		Map<Person, List<BankAccount>> collect = bankAccounts.stream()
				.collect(Collectors.groupingBy(ba -> ba.getOwner()));
		
		return collect;
		
	}
	
	public static List<String> allianateBankAccounts(List<BankAccount> bankAccounts) {
		return bankAccounts
				.stream()
				.map(BankAccount::getIBANN)
				.map(s -> allianateIbann(s))
				.collect(Collectors.toList());
	}
	
	public static String allianateIbann(String ibann) {
		return ibann.substring(0, 2) + ibann.substring(2).replaceAll("\\d", "*");
	}
	
	public static Map<Integer, List<Person>> getPersonsByAge(List<Person> persons) {
		return persons.stream().collect(Collectors.groupingBy(Person::getAge));
	}
	
	public static long countWordsByCharacter(String sentence, String a) {
		List<String> asList = Arrays.asList(sentence.split(" "));
		return asList.stream().map(s -> s.toLowerCase()).filter(s -> s.startsWith(a)).count();
	}
	
	public static boolean isNumber(String isNumber) {
		return isNumber.chars().allMatch(Character::isDigit);
	}
	
	public static List<String> getIbannsForCustomers(List<Person> persons) {
		return persons.stream()
				.flatMap(p -> p.getBankAccounts().stream())
				.map(ba -> ba.getIBANN())
				.map(b -> allianateIbann(b))
				.collect(Collectors.toList());
	}
	
	public static String ofLegalAge(List<Person> persons) {
		return persons.stream()
		.filter(p -> p.age > 17)
		.map(Person::getName)
		.collect(Collectors.joining(" and ", "In Germany ", " are of legal age"));
	}
}
