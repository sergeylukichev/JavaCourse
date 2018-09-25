import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class CollectionDemo {

    public static String [] names = {"Ivan", "Maria", "Stephan", "John", "Johann"};
        
    public static void main(String[] args) {
	    List<String> list = new ArrayList<>();
	    
	    list.add("1");
	    list.add("1");
	    list.add("1");
	    list.add("1");
	    list.add("1");
	    list.add("1");
	    list.add("1");
//	    list.add("3");
//	    list.add("5");
//	    list.add("7");
//	    list.add("0");
//	    list.add("9");
//	    list.add("9");
	    
	    List<String> list2 = new ArrayList<>();
	    list2.add("1");
	    list2.add("1");
	    list2.add("1");
	    list2.add("3");
//	    list2.add("5");
//	    list2.add("7");
//	    list2.add("0");
//	    list2.add("9");
	    
	    list.removeAll(list2);
	    System.out.println(list.isEmpty());
	    
//	    List<String> res = new ArrayList<>();
//	    for(String elem:list) {
//	    	res.add(list2.contains(elem)?"yes":"no");
//	    }
//	    
//	    System.out.println(res);
	    
	    
//	    Map<Integer, String> map = new HashMap<>();
//	    
//	    Set<String> set = new HashSet<>();
//	    
//	    set.addAll(Arrays.asList(names));
//	    
//	    System.out.println("set "+set);
//	    
//	    set.add("Ivan");
//	    
//	    System.out.println(set);
	    
        //populateIntList(list);  
//	    list.addAll(Arrays.asList(names));
//        System.out.println("before " + list); 
//        
//        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(k->k, v->v.length()));
//        
//        System.out.println("test "+collect);
//        List<String> namesToRemove = new ArrayList<>();
//        for(String name:list) {
//        	if(name.length() == 4) {
//        		namesToRemove.add(name);
//        	}        	
//        }
        
        //list.removeAll(namesToRemove);
        
        Iterator<String> iterator = list.iterator();
        
        while(iterator.hasNext()) {
        	String name = iterator.next();
        	if(name.length() == 4) {
        		iterator.remove();
        	}
        }
        
        System.out.println(list);
        
//        
//        List<String> namesToRemove = new ArrayList<>();
//        for(String name:list) {
//        	if(name.length()==4) {
//        		System.out.println("Name length of 4 "+name);
//        		namesToRemove.add(name);
//        	}
//        }
//        
//        System.out.println("Names to remove "+namesToRemove);
//        
//        list.removeAll(namesToRemove);
//       
//        System.out.println("After "+list);
//        
//        
//        
//        
//        
//        
//        
//        Iterator<String> iterator = list.iterator();
//
//        while(iterator.hasNext()) {
//            String name = iterator.next();
//            if(name.length()==4) {
//                iterator.remove();
//            }
//        }
//
////        for(String name:list) {
////            if(name.length()==4) {
////                list.remove(name);
////            }
////        }
//
//        System.out.println(list);
//
//
//        Set<String> set = new HashSet<>();
//
//        populateHashSet(set);
//
//        System.out.println(set);

    }

 

    public static void populateHashSet(Set<String> set) {
        for(int i=0;i<5;i++) {
            String nameToAdd = names[ThreadLocalRandom.current().nextInt(0, 5)];
            System.out.println("Adding "+nameToAdd);
            set.add(nameToAdd);
        }
    }
    
    public static void populateIntList(List<String> list) {
        for(int i=0;i<5;i++) {
            list.add(names[ThreadLocalRandom.current().nextInt(0, 5)]);
        }
    }
}