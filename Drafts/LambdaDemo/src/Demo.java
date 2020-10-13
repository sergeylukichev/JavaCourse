import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {
    public static void main(String[] args) {
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        DemoIntterface demo = new DemoImpl();

        System.out.println(demo.trasform(5));


        String someString = DemoIntterface.SOME_STRING;

        DemoIntterface dia = new DemoIntterface() {
            @Override
            public String getString(int i) {
                return String.valueOf(i);
            }
        };

        DemoIntterface di = (a) -> String.valueOf(a);

        //"abc" -> 3
        Function<String, Integer> f1 = (s) -> s.length();

        // 5 -> 25

        Function<Integer, Integer> f2 = (a) -> a * a;

        Predicate<String> f3 = (s) -> s.length() % 2 == 0;

        Consumer<String> f4 = (s) -> System.out.println(s);

        Supplier<Integer> f5 = () -> (int)(Math.random());


//        {
//          if(s.length() % 2 == 0) return true;
//          else return false;
//        };

        Function<Integer, Integer> ff1 = (a) -> a*a;
        doSomeMath(ff1, 10);

        Function<Integer, Integer> ff2 = (a) -> a*10;
        doSomeMath(ff2, 24);

        Function<Integer, Integer> ff3 = Demo::getInt;
        doSomeMath(ff3, 56);

        Function<String, String> getString = Demo::getString;

        Function<String, String> getStringL = (s) -> s;

        transformString((s) -> s, "abc");
        transformString(Demo::getString, "abc");


        Function<String, String> type = Person::type;

        Person p = new Person("Ivan");

        Supplier<String> getName = p::getName;

        System.out.println(getName.get());

        Function<Person, String> getName1 = Person::getName;

        System.out.println(getName1.apply(p));

        Supplier<Person> person = Person::new;

    }

    public static int getInt(int a) {
        return a%2==0 ? 1: -1;
    }

    public static String transformString(Function<String, String> f, String s) {
        return f.apply(s);

    }

    public static int doSomeMath(Function<Integer, Integer> f, int a) {
        System.out.println(a);
        return f.apply(a);
    }

    public static String getString(String input) {
        return input;
    }
}
