import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsReader {

	public static void main(String [] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("persons.txt"));
				PrintWriter pw = new PrintWriter(
						new FileWriter("C:\\Users\\LenovoUser\\sergey\\2018_05_22_Readers\\sorted_persons.txt"))) {
			br.lines()
			.map(s -> stringToPerson(s))
			.sorted(Comparator.comparing(Person::getAge))
			.forEach(pw::println);
		}
	}
	
	public static Person stringToPerson(String s) {
		String [] p = s.split(",");
		return new Person(p[0], Integer.parseInt(p[1]));
	}
	
	public static String personToString(Person p) {
		return p.name + "," + p.age;
	}
}
