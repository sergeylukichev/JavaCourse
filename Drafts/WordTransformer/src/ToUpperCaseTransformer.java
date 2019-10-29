public class ToUpperCaseTransformer implements Transformer {
    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }
}
