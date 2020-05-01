import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

    //Arrays:
    //adding is not convenient when index > length
    //deletion requires recreation or putting last element to the place of deleted
    //update,search
    //getElementByIndex
    //addFirst

    // set - TreeSet - Sergii
    // set - HashSet - Dmitrii
    // map - TreeMap - Alexander
    // map -  HashMap - Evgeni
    // deque - LIFO, LILO, Stack -


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        Collections.addAll(list, "Hello", "World", "one", "two", "three");
        Collections.sort(list);

        List<String> strings = Arrays.asList("Hello", "World", "one", "two", "three");

        System.out.println(strings.getClass().getName());

        System.out.println(strings);

        System.out.println(list);



        Iterator<String> iterator = getIterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static Iterator<String> getIterator() {
        Set<String> list = new TreeSet<>();
        list.add("Hello");
        list.add("World");
        return list.iterator();
    }

    public static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        return list;
    }
}
