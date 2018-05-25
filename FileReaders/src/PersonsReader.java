import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsReader {

	public static void main(String [] args) throws IOException {
		List<Person> persons = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("persons.txt"))) {
			persons = br.lines()
			.map(s -> stringToPerson(s))
			.collect(Collectors.toList());
		}
		
		System.out.println(persons);
	}
	
	public static Person stringToPerson(String s) {
		String [] p = s.split(",");
		return new Person(p[0], Integer.parseInt(p[1]));
	}
	
	public static String personToString(Person p) {
		return p.name + "," + p.age;
	}
}
