import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        System.out.println("Hello World");

        int a = 2+3;

        String s = "Hello World";

        Employee e = new Employee("Ivan", 2500);

        Consumer<String> printable = System.out::println;
        printable.accept("Hello World!");

        Consumer<String> printable2 = str -> System.out.println(str);

        printable2.accept("Hello World Again");

        PrintableI pi = System.out::println;

        pi.print("Hello World Custom");

        Consumer<String> printer = getPrinter();
        printer.accept("adsfadfs");

        printSomething(str -> System.out.println(str));
        printSomething(getPrinter());

        int maxSalary = Employee.getMaxSalary();

        //Method reference to static method
        Supplier<Integer> getMaxSalary = Employee::getMaxSalary;

        Employee mike = new Employee("Mike", 3500);

        //method reference to non static method with no instance

        Function<Employee, Integer> getSalary = Employee::getSalary;
        System.out.println("mike's salary is " + getSalary.apply(mike));

        //method reference to non static method with instance
        Supplier<Integer> getMikesSalary = mike::getSalary;
        System.out.println("mike's salary is " + getMikesSalary.get());

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = list.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> integers = list
                .stream()
                .filter(i -> i > 3)
                .collect(Collectors.toList());

        System.out.println(integers);

        List<Employee> employees = Arrays.asList(e, mike);

        List<String> employeeNames = employees
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Employee names "+employeeNames);

        List<Integer> employeeSalaries = employees
                .stream()
                .map(Employee::getSalary)
                .filter(i -> i > 2700)
                .collect(Collectors.toList());
        System.out.println(employeeSalaries);

        employees
                .stream()
                .map(Employee::getSalary)
                .forEach(System.out::println);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        Integer reduce = integerStream.reduce(0, (a1, b1) -> a1 + b1);
        System.out.println("Reduced list of integers "+reduce);

        Stream<String> strings = Stream.of("I", "have", "a", "dream");

        String reduce1 = strings.reduce("", (st1, st2) -> st1 + " "+ st2);
        System.out.println(reduce1);

        Stream<Integer> integerStream1 = employees
                .stream()
                .filter(i -> i.getSalary() > 2700)
                .map(empl -> {
                    System.out.println(" Employee " + empl);
                    return empl.getSalary();
                });

        integerStream1.collect(Collectors.toList());
        //integerStream1.collect(Collectors.toList());
        //.collect(Collectors.toList());
        //System.out.println(salaries);

        boolean b = employees.stream().allMatch(p -> p.getSalary() > 5000);
        System.out.println("All more than 1000? "+b);
        boolean c = employees.stream().anyMatch(p -> p.getSalary() > 5700);
        System.out.println("Anyone more than 2700? "+c);


    }

    public static Consumer<String> getPrinter() {
        return System.out::println;
    }

    public static void printSomething(Consumer<String> c) {
        c.accept("asfdfsdf");
    }
}
