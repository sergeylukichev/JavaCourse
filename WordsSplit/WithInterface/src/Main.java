
public class Main {
    public static void main(String[] args) {
        String input = "aaa BC de FGH bce EF";

        WordsTransformer wt = new WordsTransformer();

      //  WordsChecker wc1 = new ToUpperCaseChecker();
        System.out.println(wt.transform(input, ToUppercaseChecker.checkWord(input), transformWordToUpperCase.transformWord(input));

        WordsChecker wc2 = new ToLowerCaseChecker();
        System.out.println(wt.transform(input,ToLowerCaseChecker.checkWord(input), ));
    }

    public static WordsChecker ToLowerCaseChecker = (String word) -> {
        return word.length() == 2;
    };


    public static WordsChecker ToUppercaseChecker = (String word) -> {
        return word.length() == 3;
    };

    public static WordsTransformerInterface transformWordToUpperCase = (String word) -> {
        return word.toUpperCase();
    };

    public static  WordsTransformerInterface TransformWordToLowerCase = (String word) -> {
        return word.toLowerCase();
    };


}
