public class Box {
    int amount;

    public Box(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Box{" +
                "amount=" + amount +
                '}';
    }
}
