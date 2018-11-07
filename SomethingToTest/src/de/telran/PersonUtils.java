package de.telran;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.telran.model.Address;
import de.telran.model.Person;

public class PersonUtils {
	
	
	
	public static String noDuplicateNames(String names) {
		List<String> namesList = Arrays.asList(names.split(" "));
		return namesList.stream().collect(Collectors.toSet()).toString();
	}
	
	public static List<Address> getAddresses(List<Person> persons) {
		return persons.stream().filter(p -> p.getAge() > 17).map(p -> p.getAddress()).collect(Collectors.toList());
	}	

	public static int sumAge(List<Person> persons) {

		return persons.stream()
				.filter(p -> p.getAge() > 17)
				.reduce(0, (a, b) -> a + b.getAge(), (a, b) -> a + b);
		
	}
	
	public static Map<Integer, List<Person>> getPersonsByAge(List<Person> persons) {
		return persons.stream().collect(Collectors.groupingBy(Person::getAge));
	}
	
	public static long countWordsByCharacter(String sentence, String a) {
		List<String> asList = Arrays.asList(sentence.split(" "));
		return asList.stream().map(s -> s.toLowerCase()).filter(s -> s.startsWith(a)).count();
	}	

	public static String ofLegalAge(List<Person> persons) {
		return persons.stream()
		.filter(p -> p.getAge() > 17)
		.map(Person::getName)
		.collect(Collectors.joining(" and ", "In Germany ", " are of legal age"));
	}
}
