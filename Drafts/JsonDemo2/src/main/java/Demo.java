import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Demo {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Person[] person =
                mapper.readValue(
                        new File("persons.json"),
                        Person[].class);

        System.out.println(person);
    }
}
