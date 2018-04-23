import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        List list = new ArrayList();
        list.add("hello");

        String hello = (String)list.get(0);//need explicit cast otherwise error

        //list is parametrised, only strings can be added, not need explicit cast when get(0)
        List<String> stringList = new ArrayList<>();
        stringList.add("hello world");
        String hello2 = stringList.get(0);

        //You may define a type, which the box may contain
        Box<String> box = new Box<>();
        box.set("Hello World");

        String s = box.get();
        System.out.println("box contains "+ s);

//        E - Element (used extensively by the Java Collections Framework)
//        K - Key
//        N - Number
//        T - Type
//        V - Value
//        S,U,V etc. - 2nd, 3rd, 4th types

        
        //raw types - not type parameters
        Box<String> stringBox = new Box<>();
        Box rawBox = stringBox;
        rawBox.set(new Integer(8)); //no compile time error, but warning

        //execution error since stringBox now contains Integer and fails
        //System.out.println(stringBox.get());
        
        
        //generic methods - return generic type

        Integer [] intArray = {1, 2, 3, 4, 5};

        System.out.println("Integers more than 3 "+countGreaterThan(intArray, 3));

        Double [] doubleArray = {1.5, 2.3, 3.4, 4.4, 5.8};

        System.out.println("Doubles more than 3 "+countGreaterThan(doubleArray, 3.0));

        List<Integer> intList = Arrays.asList(intArray);

        List<Double> doubleList = Arrays.asList(doubleArray);

        //upper bounded wildcards
        double doubleSum1 = sumOfList(intList);
        double doubleSum2 = sumOfList(doubleList);


        //unbounded Wildcards
        printList(intList);


    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem)>0)
                ++count;
        return count;
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
 
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void printList(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }
}