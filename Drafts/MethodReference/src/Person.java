
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Person {
    String name;

    public Person(String name, int i) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person p = new Person("Frank", 10);

        //method reference: specified instance
        Supplier<String> getName = p::getName;
        System.out.println(getName.get());

        //method reference: unspecified instance
        Function<Person, String> getName1 = Person::getName;
        String franksName = getName1.apply(p);
        System.out.println(franksName);

        //method reference to a constructor with 2 arguments, as bi-funciton
        BiFunction<String, Integer, Person> f = Person::new;
        Person maria = f.apply("Maria", 10);
    }
}
