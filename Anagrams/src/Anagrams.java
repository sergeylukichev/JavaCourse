import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
    	
    	String[] dict = {"ivan", "vani", "navi", "mir", "rim", "car", "to", "as", "sa", "war", "raw", "world", "maria"};
    	
        // Read words from dict and put into a simulated multimap
        Map<String, List<String>> m = new HashMap<String, List<String>>();

       
        for(String s:dict) {
   
        }
   

        // Print all anagrams
        m.forEach((k, v) -> System.out.println(k.length()+" "+v));
        
        //the output should be:
        //2 -> ["to"]
        //2 -> ["sa", "as"]
        //3 -> ["car"]
        //3 -> ["war", "raw"]
        //4 -> ["ivan", "navi", "vani"]
        //5 -> ["world"]
        //5 -> ["maria"]
    }
}