import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person ("Piotr", "Ivanov");
		Person p2 = new Person ("Piotr", "Ivanov");
		Person p4 = new Person ("Ivan", "Petrov");
		
		p4.setFname("Piotr");
		p4.setLname("Ivanov");
		
		//prints false since p1 and p2 refer to different objects though content is the same
		System.out.println(p1 == p2);
		
		//prints true as long as equals() for Person is implemented
		//remove equals() in Person and see 'false' is printed
		System.out.println("Equals "+p1.equals(p4));
		
		Set<Person> set = new HashSet<>();
		
		//prints false since hashCode() is redefined for Person and it is the same for 2 objects with the same content
		//remove hashCode() from Person and see 2 objects with the same content added to the set
		set.add(p1);
		System.out.println("Adding? " +set.add(p2));
		
		//if hashCode() is not defined in Person, then set contains 2 elemnts though their content is the same
		System.out.println(set.size()+ " "+ set);
		
		String c = new String("Piotr");
		String d = new String("Piotr");
		
		//prints true since compare the same strings (equals() is overwritten in class String)
		System.out.println(c.equals(d));
		
		//prints false since c and d are different objects created with 'new'
		System.out.println(c == d);
		
		String a = "Piotr";
		String b = "Piotr";
		
		//prints true since a and b refer to the same string
		System.out.println(a == b);
				
		List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8));
		System.out.println("not sorted "+list);
		
		//custom sort() method creates a copy of original list and then sort the copy, not the original one
		//working with the copy makes sense, especially if returned list is changed (elements added/removed)
		//the original list better keep untouched
		List<Integer> sorted = sort(list);
		System.out.println("Sorted "+sorted );
		System.out.println("Original one "+sorted );
				
		Person person = new Person("Piotr", "Ivanov");
		
		//copyPerson method use copying constructor or Person to create a copy
		Person copyPerson = copyPerson(person);
		
		//therefore person and copyPerson are different objects in memory (prints false)
		System.out.println("person ==  copyPerson "+(person == copyPerson));
	}
	
	public static List<Integer> sort(List<Integer> list) {
		List<Integer> copy = new ArrayList<>(list);
		Collections.sort(copy);
		return copy;
	}
	
	public static Person copyPerson(Person p) {
		Person ret = new Person(p);
		ret.lname = "****";
		return ret;
	}	
}