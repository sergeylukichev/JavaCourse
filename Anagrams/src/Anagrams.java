import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Given a vocabulary, implement a function, 
 * which returns a list of anagrams for a given word from the vocabulary. 
 * It is important to notice a common property of an anagram of a word and the word: 
 * their alphabetically ordered lists of characters are equal. 
 * For example, the word if "ivan" and its anagram "vani" have 
 * the same list of characters in common: ['a', 'i', 'n', 'v']
 */

public class Anagrams {
	
	static String[] dict = {
			"ivan", 
			"vani", 
			"navi", 
			"mir", 
			"rim", 
			"car", 
			"to", 
			"as", 
			"sa", 
			"war", 
			"raw", 
			"world", 
			"maria"};
	
	static Map<String, List<String>> createDict; 
	
	public static void main(String[] args) {
		String test = alphabetize("ivan");
		System.out.println(test);
		
		createDict = createDict(dict);
		
		createDict.forEach((k, v) -> System.out.println(k +" "+ v));
		
		List<String> findAnagrams = findAnagrams("ivan");
		System.out.println(findAnagrams);
	}
	
	
	/* The one-liner solution using streams
	 * 
	 */
	public static Map<String, List<String>> createDict(String [] voc) {		
		return Arrays.asList(voc)
		.stream()
		.collect(Collectors.groupingBy(s -> Anagrams.alphabetize(s)));
	}
	
	/* old-school pre-Java 8 solution with the loop
	 * 
	 */
	
//	public static  Map<String, List<String>> createDict(String [] voc) {
//		Map<String, List<String>> ret = new HashMap<>();
//	    for(String s:dict) {
//            String alpha = alphabetize(s);
//            List<String> list = ret.get(alpha);
//            if(list == null) {
//       	       list = new ArrayList<>(); 
//       	       ret.put(alpha, list);
//            }
//            list.add(s);
//        }
//		return ret;
//	}
	
	public static String alphabetize(String input) {
		char[] charArray = input.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	public static List<String> findAnagrams(String word) {
		String alphabetize = alphabetize(word);
		return createDict.get(alphabetize);
	}
}