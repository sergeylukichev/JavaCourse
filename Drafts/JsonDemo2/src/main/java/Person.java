import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Person {
    private String firstName;
    private int age;

    public Person(String name, int age) {
        this.firstName = name;
        this.age = age;
    }

    public Person() {

        System.out.println("Creating a person");
    }

    @JsonSetter("name")
    public void setFirstName(String firstName) {
        System.out.println("setting firstName");
        this.firstName = firstName;
    }

    public void setAge(int age) {

        System.out.println("setting age");
        this.age = age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
