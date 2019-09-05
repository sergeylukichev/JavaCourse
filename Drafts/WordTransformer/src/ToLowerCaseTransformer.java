public class ToLowerCaseTransformer implements Transformer {

    @Override
    public String transform(String input) {
        return input.toLowerCase();
    }
}
