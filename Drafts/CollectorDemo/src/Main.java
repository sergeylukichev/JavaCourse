import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan", 1500);
        Person p2 = new Person("Piotr", 1800);
        Person p3 = new Person("Maria", 2600);
        Person p4 = new Person("Elena", 1000);

        Supplier<Box> supp = () -> {
            System.out.println("Supplying starting value");
            return new Box(0);
        };

        BiConsumer<Box, Person> accumulator = (result, person) -> {
            result.setValue(result.getValue() + person.getSalary());
            System.out.println(result.getValue() + " " + person);
        };

        BinaryOperator<Box> combiner = (res1, res2) -> {
            System.out.println("Combining results");
            res1.setValue(res1.getValue() + res2.getValue());
            return res1;
        };

        BinaryOperator<Box> combiner2 = (res1, res2) -> {
            System.out.println("Combining results 2");
            return res1;
        };

        Collector<Person, Box, Box> collector = Collector.of(
                supp,
                accumulator,
                combiner2

        );

        Box box = Stream.of(p1, p2, p3, p4)
                .parallel()
                .collect(collector);

        System.out.println("Total salary " + box);
    }
}
