import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		String sentence = "aAb bbb aDaD ccc DDDD";
		//length == 3 -> toUpperCase
		// AAB BBB CCC DDDD
		
		//length ==4 -> toLowerCase
		//aAb bbb ccc dddd
				
		Function<String, String> f1 = s -> s.toUpperCase();
		
		Function<String, String> f2 = s -> s.toLowerCase();
				
		Predicate<String> p1 = t -> t.length() == 3;
		
		Predicate<String> p2 = t -> t.length() == 4;
			
		System.out.println(transform(sentence, f1, p1));
		System.out.println(transform(sentence, f2, p2));
		
	}
		
	public static String transform(String sentence, 
			Function<String, String> f,
			Predicate<String> p) {
		String [] words = sentence.split(" ");
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			if(p.test(word)) {
				words[i] = f.apply(word);
			}
		}
		return String.join(" ", words);
	}
}
