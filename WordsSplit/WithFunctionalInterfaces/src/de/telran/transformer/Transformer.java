package de.telran.transformer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Transformer {		
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
