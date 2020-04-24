public class WordTransformer {
    //length == 3 -> to UpperCase
    //transform("aaa bcDE eklm iii") -> "AAA bdDE eklm III"

    //length == 5 -> toLowerCase
    //transform("aaa bcDEf eklm iiiPM") -> "aaa bcdef eklm iiipm"

    //length ==2 -> relace first char with *
    //transform("aa bcDEf ek") -> "*a bcDEf *k"

    public static String transform(String input, RuleInterface c) {
        String[] words = input.split(" ");
        for(int i = 0; i< words.length; i++ ) {
            String word = words[i];
            if (c.check(word)) {
                words[i] = c.action(word);
            }
        }
        return String.join(" ", words);
        //nothing is executed after this line
    }

    public static String transform(String input) {
        RuleInterface c = new TransformerRuleLentgh3();
        return transform(input, c);
    }
}
