public class DemoImpl implements DemoIntterface {

    int anInt;

    @Override
    public String getString(int i) {
        return String.valueOf(i);
    }

    @Override
    public String trasform(int i) {
        anInt = 3;
        return "Hello World " + i + anInt;
    }
}
