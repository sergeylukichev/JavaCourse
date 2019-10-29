package de.telran.transformer;

import java.util.function.Function;
import java.util.function.Predicate;

public class Transformer {

    public static String transform(String s) {
        return transform(s,
                s1 -> s1.length() == 3,
                s1 -> s1.toUpperCase());
    }

    public static String transform(String sentence,
                                   Predicate<String> p,
                                   Function<String, String> f) {
        String [] words = sentence.split(" ");
        for(int i = 0; i< words.length; i++) {
            if(p.test(words[i])) {
                words[i] = f.apply(words[i]);
            }
        }
        return String.join(" ", words);
    }
}
