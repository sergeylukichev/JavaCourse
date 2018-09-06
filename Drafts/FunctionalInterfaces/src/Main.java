import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
	
	public static void main(String[] args) {
		String [] strings = {"ccc", "bbb", "aaa", "ddd"};
		
//		System.out.println("Before:");
//		for(String s:strings) {
//			System.out.println(s);			
//		}

		Arrays.sort(strings);
		
//		System.out.println("After:");
//		for(String s:strings) {
//			System.out.println(s);	
//		}
		
		MyNumber [] numbers = {new MyNumber(3, "aaa"), 
				new MyNumber(2, "ddd"),
				new MyNumber(5, "bbb"),
				new MyNumber(1, "ccc")};
		
		MyNumberComparator mc = new MyNumberComparator();
		
		
		//comparator with anonymous class
		Comparator<MyNumber> c = new Comparator<MyNumber>() {

			@Override
			public int compare(MyNumber o1, MyNumber o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				return name1.compareTo(name2);
			}

		};
		
		//comparator with lambda function
		Comparator<MyNumber> c2 = 
				(m1, m2) -> {
					String name1 = m1.getName();
					String name2 = m2.getName();
					return name1.compareTo(name2);
				};
				
				
		//comparator with even better lambda function
		Comparator<MyNumber> c3 = (m1, m2) -> 
				m1.getName().compareTo(m2.getName());
		
		Arrays.sort(numbers, c2);
		
//		for(MyNumber number:numbers) {
//			System.out.println(number);
//		}
		
		//implementing interface using anonynous class
		MyFunction myFunction = new MyFunction() {
			
			@Override
			public boolean check(Integer a, Integer b) {
				return a>b;
			}
		};
		
		System.out.println(myFunction.check(10, 25));
		
		//implementing functional interface with lambda function
		MyFunction myFunction2 = (a, b) -> a > b;
		
		boolean check = myFunction2.check(10, 15);
		System.out.println(check);
		
		//standard java functional interfaces: Function and Predicate
		Function<String, Integer> f = s -> s.length();
		Predicate<String> p = s -> s.length()==3;
		
		System.out.println(f.apply("aaa")+ " "+p.test("aab"));
		
	}
	
	public static int compare(MyNumber m1, MyNumber m2) {
		if(m1.getNumber()> m2.getNumber()){
			return 1;
		} else {
			return -1;
		}
	}

}
