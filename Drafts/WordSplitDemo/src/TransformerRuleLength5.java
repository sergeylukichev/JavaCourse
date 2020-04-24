public class TransformerRuleLength5 implements RuleInterface {

    @Override
    public boolean check(String word) {
        return word.length() == 5;
    }

    @Override
    public String action(String word) {
        return word.toLowerCase();
    }
}
