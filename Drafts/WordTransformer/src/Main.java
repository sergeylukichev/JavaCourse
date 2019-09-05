public class Main {

    public static void main(String[] args) {
        String input = "Big brown fox";

        Checker c = s -> s.length() == 3;

        Transformer t = s -> s.toUpperCase();
        //Transformer t = new ToLowerCaseTransformer();
        String output = transform(input, c, t);

        String expected = "BIG brown FOX";

        System.out.println(expected.equals(output));//true
    }

    //Big brown fox -> BIG brown FOX
    // length == 3 -> toUpperCase()
    //
    // Big brown fox -> BIG brown FOX
    // length == 5 -> toUpperCase()

    //Big BRown fox -> Big brown fox
    //length == 5 -> toLowerCase()

    //Big brown fox -> *** brown ***
    //length == 3 -> to *

    public static String transform(String sentence,
                                   Checker c,
                                   Transformer t) {
        String[] words = sentence.split(" ");
        for(int i = 0; i< words.length; i++) {
            if(c.check(words[i])) {
                words[i] = t.transform(words[i]);
            }

        }
        return String.join(" ", words);
    }

}
