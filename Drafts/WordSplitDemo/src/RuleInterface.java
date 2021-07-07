public interface RuleInterface {

    boolean check(String word);
    String action(String word);

    default String newMethod() {
        return "Test";
    }
}
