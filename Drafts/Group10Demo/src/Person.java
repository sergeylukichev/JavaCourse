public class Person {

    String firstName;
    String lastName;

    private Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Person createPerson(String firstNameAndLastName) {
        String[] split = firstNameAndLastName.split(";");
        return new Person(split[0], split[1]);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
