public abstract class Person {

    //immutable
    //private, public, protected, default
    private String firstName;
    private String lastName;


    public Person(final String f, final String l) {
        this.firstName = f;
        this.lastName = l;
        System.out.println("Hello " + firstName);
    }
}
