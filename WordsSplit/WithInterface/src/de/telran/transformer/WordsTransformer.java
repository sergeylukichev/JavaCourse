package de.telran.transformer;

import java.util.function.Function;
import java.util.function.Predicate;

public class WordsTransformer {


	public static String transform(String s) {
		return transform(s,
				s1 -> s1.length() == 3,
				s1 -> s1.toUpperCase());
	}
	
	public static String transform(String sentence, Predicate<String> wc3, Function<String, String> wti3) {
		String [] words = sentence.split(" ");
		
		for(int i=0;i<words.length;i++) {
			if(wc3.test(words[i])) {
				words[i] = wti3.apply(words[i]);
			}
		}

//		 wc3 = s -> {
//			return s.length() == 2;
//		};
//
//
//		 Predicate<String> toUppercaseChecker = (String word) -> {
//			return word.length() == 3;
//		};
//
//		wti3 = (String word) -> {
//			return word.toUpperCase();
//		};
//
//		  Function<String, String> transformWordToLowerCase = (String word) -> {
//			return word.toLowerCase();
//		};



		return String.join(" ", words);
	}

//	public String transform(String sentence, Predicate<String> wc2, Function<String, String> wti2) {
//		String [] words = sentence.split(" ");
//
//		for(int i=0;i<words.length;i++) {
//			if(wc2.test(words[i])) {
//				words[i] = wti2.apply(words[i]);
//			}
//		}
//
//
//
//		return String.join(" ", words);
//	}







}
