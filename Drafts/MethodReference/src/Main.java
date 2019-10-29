import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Address a1 = new Address("Mira", 115);
        Address a2 = new Address("Pravdy", 25);
        Address a3 = new Address("Lenina", 13);
        Address a4 = new Address("Sadovay", 44);

        Person p1 = new Person("Ivan", 15, a1);
        Person p2 = new Person("Piotr", 18, a2);
        Person p3 = new Person("Maria", 26, a3);
        Person p4 = new Person("Elena", 10, a4);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4);

        List<Address> collect = persons
                .stream()
                .filter(p -> p.age > 17)
                .map(Person::getAddress)
                .collect(Collectors.toList());
        System.out.println(collect);

        Stream<String> ivan = Stream.of("Ivan", "Piotr", "Ivan", "Piotr", "Maria", "Ivan");
        Set<String> collect1 = ivan.collect(Collectors.toSet());
        System.out.println(collect1);

        Stream<String> ivan1 = Stream.of("Ivan",
                "Piotr",
                "Elena",
                "Anna",
                "Maria",
                "Ian");

        // 4 -> {Ivan, Anna}
        // 3 -> {Ian}
        // 5 -> {Elena, Maria, Piotr}

        Map<Integer, List<String>> listMap = ivan1
                .collect(Collectors.groupingBy(String::length));

        listMap.forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });

        Map<Integer, String> collect2 = persons
                .stream()
                .collect(Collectors.toMap(
                        Person::getAge,
                        Person::getName
                ));
        System.out.println(collect2);

        BankAccount b1 = new BankAccount("DE123123", p1);
        BankAccount b2 = new BankAccount("NL675342", p2);
        BankAccount b3 = new BankAccount("FR879405", p3);
        BankAccount b4 = new BankAccount("DE096342", p4);

        Stream<BankAccount> b11 = Stream.of(b1, b2, b3, b4);

        List<String> collect3 =
                b11.map(b -> alianate(b.getIban()))
                .collect(Collectors.toList());

        System.out.println(collect3);


    }

    public static String alianate(String input) {
        return "******";
    }
}
