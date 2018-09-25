import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetMapDemo {
	
	public static void main(String[] args) {
		String [] names = {"Maria", "Sofia", "Maria", "Ivan", "Piotr", "Piotr"};
		
		List<String> list = new ArrayList<>(Arrays.asList(names));
		
		System.out.println("Input names "+list);
		
		Map<String, Integer> nameToCountMap = new HashMap<>();
		
		for(String name:list) {
			if(nameToCountMap.containsKey(name)) {
				Integer count = nameToCountMap.get(name);
				nameToCountMap.put(name, count+1);
			} else {
				nameToCountMap.put(name, 1);
			}
		}		
		System.out.println(nameToCountMap);	
		
		Map<Integer, List<String>> countToNamesMap = new HashMap<>();
		
		for(String name:list) {
			if(countToNamesMap.containsKey(name.length())) {
				List<String> namesList = countToNamesMap.get(name.length());
				namesList.add(name);
			} else {
				List<String> namesList = new ArrayList<String>();
				namesList.add(name);
				countToNamesMap.put(name.length(), namesList);
			}
		}
		
		System.out.println(countToNamesMap);
				
		Set<String> unique = new HashSet<>();
		Set<String> duplicate = new HashSet<>();
		
		for(String name:names) {
			
			if(!unique.add(name)) {
				duplicate.add(name);
			}
		}
		
		System.out.println("Duplicate names "+duplicate);
		
		unique.removeAll(duplicate);
		System.out.println("Unique names "+unique);
	}

}
