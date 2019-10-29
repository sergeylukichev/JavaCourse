public class BankAccount {
    String iban;
    Person owner;

    public BankAccount(String iban, Person owner) {
        this.iban = iban;
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", owner=" + owner +
                '}';
    }
}
