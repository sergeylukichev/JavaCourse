public class MilkDecorator extends AbstractDecorator {
    private final static int MILK_PRICE = 10;

    public MilkDecorator(Coffe coffe) {
        super(coffe);
    }

    public int getPrice() {
        int price = super.getPrice() + MILK_PRICE;
        System.out.println("Price for coffe with milk "+price);
        return price;
    }

}
