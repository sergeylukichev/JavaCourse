public class TransformerRuleLentgh3 {
    //no fields -> no state
    public boolean check(String input) {
        return input.length() == 3;
    }

    public String action(String input) {
        return input.toUpperCase();
    }
}
