import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		List<String> emptyList = Collections.emptyList();
		
		List<String> strings = new ArrayList<>();
	
		boolean isAdded = Collections.addAll(strings, "aa", "bb", "cc");
		
		Collections.reverse(strings);
		
		System.out.println(strings+ " "+ isAdded);
		
		
		
		Integer [] array = {1, 2, 3, 5};
		
		List<Integer> l1 = Arrays.asList(array);
		
		System.out.println(l1.getClass().toString());
		
		//Collections.addAll(l1, 1, 2, 3, 5);

		List<Integer> l2 = new LinkedList<>(); 
		Collections.addAll(l2, 2, 2, 3, 6);

		List<String> compareLists = compareLists(l1, l2);
		System.out.println(compareLists);
		
		
		List<String> listOfStrings = Arrays.asList("aa", "bb", "cc");

		Set<String> setofStrings = new HashSet<>(listOfStrings);
		
		boolean added = setofStrings.add("dd");
		System.out.println("is added "+added);
		
		System.out.println(setofStrings);
		
		Set<Integer> setofIntegers = new HashSet<>();
		setofIntegers.add(1);
		setofIntegers.add(5);
		setofIntegers.add(2);
		setofIntegers.add(7);
		
		setofIntegers.remove(7);
		
		System.out.println("original set of integers "+setofIntegers);
		
		Iterator<Integer> iterator = setofIntegers.iterator();
		
		while(iterator.hasNext()) {
			
			Integer i = iterator.next();
			if(i>2) {
				//setofIntegers.remove(i);
				iterator.remove();
			}
		}
		
		System.out.println("set without some elements " + setofIntegers);
		
		List<String> newStringList = new LinkedList<>(setofStrings);
		
		System.out.println(newStringList);
		
	}
	
	public static List<String>  getStrings() {
		return Collections.emptyList();
	}
	
	public static List<String> compareLists(List<Integer> l1, List<Integer> l2) {
		List<String> res = new LinkedList<>();
		for(int i=0;i<l1.size();i++) {
			if(l1.get(i) == l2.get(i)) {
				res.add("Yes");
			} else {
				res.add("No");
			}
		}
		return res;
	}
}
