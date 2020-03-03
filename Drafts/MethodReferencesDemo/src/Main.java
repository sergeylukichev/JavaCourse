import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 10, 7, 0);

        for(Integer elem: list) {
            System.out.println(elem);
        }
//
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        Consumer<Integer> pr = System.out::println;
        Consumer<Integer> prLambda = Main::doublePrint;



        list.forEach(pr);
        //pr.accept(i) -> System.out.println(i)

        Predicate<Integer> p1 = a -> a > 0;
        boolean b = list.stream().allMatch(p1);

        Predicate<Integer> p2 = a -> a == 0;
        boolean b1 = list.stream().noneMatch(p2);

        Predicate<Integer> p3 = a -> a == 3;
        boolean b2 = list.stream().anyMatch(p3);


        Person ivan = new Person("Ivan", 3500);
        Person piotr = new Person("Piotr", 3000);
        Person anna = new Person("Anna", 4000);

        Supplier<Integer> salary = ivan::getSalary;

        doSomething(salary);

        Supplier<Integer> s2 = () -> 10;

        doSomething(s2);

        Function<Person, Integer> getSalary = Person::getSalary;
        Integer ivanSalary = getSalary.apply(ivan);
        System.out.println("Ivan's salary: "+ivanSalary);



        Stream<String> stringStream = list
                .stream()
                .map(Main::printInt);
        stringStream.collect(Collectors.toList());


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        List<Person> persons = Arrays.asList(ivan, piotr, anna);

        Comparator<Person> comparingPersonByName =
                Comparator.comparing(Person::getName);

        Collections.sort(persons, comparingPersonByName);

        Comparator<Person> comparingPersonBySalary =
                Comparator.comparing(Person::getSalary);

        Collections.sort(persons, comparingPersonBySalary);

        list.stream().map(a -> a>10).collect();

    }

    public static String printInt(int i) {
        System.out.println("Value of i "+i);
        return String.valueOf(i);
    }

    public static int sumUpMoreThan3Streams(List<Integer> list) {
        return list.stream()
                .filter(a -> a>3)
                //.reduce((a, b)-> a+b)
                //.get();
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int sumUpMoreThan3(List<Integer> list) {
        int ret = 0;
        for(Integer a:list) {
            if (a > 3) {
                ret = ret + a;
            }
        }
        return ret;
    }

    public static List<String> createListStreams(List<Integer> list) {
        List<String> ret = list.stream()
                .filter(a -> a > 3)
                .map(String::valueOf)
                .collect(Collectors.toList());
        return ret;
    }

    public static List<Integer> createList(List<Integer> list) {
        List<Integer> ret = new ArrayList<>();
        for(Integer a:list) {
            if(a>3) {
                ret.add(a);
            }
        }
        return ret;
    }

    public static void doSomething(Person p) {
        System.out.println(p.getSalary());
    }


    public static void doSomething(Supplier<Integer> s) {
        System.out.println(s.get());
    }

    private static void doublePrint(Integer i) {
        System.out.println(i);
        System.out.println(i+1);
    }
}
