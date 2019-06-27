import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollectorDemo {

    public static void main(String[] args) {
        Person p1 = new Person("Ivan", 15, null);
        Person p2 = new Person("Piotr", 18, null);
        Person p3 = new Person("Maria", 26, null);
        Person p4 = new Person("Elena", 10, null);

        Supplier<Box> supp = () -> {
            System.out.println("Supplying starting value");
            return new Box(0);
        };

        BiConsumer<Box, Person> accumulator = (result, person) -> {
            result.setAmount(result.getAmount() + person.getAge());
            System.out.println(result.getAmount() + " " + person);
        };

        BinaryOperator<Box> combiner = (res1, res2) -> {
            System.out.println("Combining results");
            res1.setAmount(res1.getAmount() + res2.getAmount());
            return res1;
        };

        Collector<Person, Box, Boolean> collector = Collector.of(
                supp,
                accumulator,
                combiner,
                b -> b.getAmount() > 50
        );

        Boolean result = Stream.of(p1, p2, p3, p4)
                //.parallel()
                .collect(collector);

        System.out.println("total age in the box "+result);
        //System.out.println("total age in the box "+box.getAmount());


    }
}
