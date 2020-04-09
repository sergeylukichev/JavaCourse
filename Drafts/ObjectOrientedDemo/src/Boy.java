public class Boy extends Person {
    String sportType;

    public Boy(String firstName, String lastName, String sport) {
        super(firstName, lastName);

        this.sportType = sport;
        System.out.println(this.sportType);
    }

}
