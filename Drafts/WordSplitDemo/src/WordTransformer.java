public class WordTransformer {
    //transform("aaa bcDE eklm iii") -> "AAA bdDE eklm III"
    //length == 3 -> to UpperCase
    public static String transform(String input) {
        String[] words = input.split(" ");
        for(int i = 0; i< words.length; i++ ) {
            String word = words[i];
            if(word.length() == 3) {
                words[i] = word.toUpperCase();

            }
        }
        return String.join(" ", words);
    }
}
