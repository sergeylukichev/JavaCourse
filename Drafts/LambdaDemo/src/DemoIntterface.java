@FunctionalInterface
public interface DemoIntterface {
    String SOME_STRING = "Hello";

    String getString(int i);
    //String transform(int i);

    default String trasform(int i) {
        return "Hello World";
    }
}
