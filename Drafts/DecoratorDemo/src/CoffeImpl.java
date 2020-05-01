public class CoffeImpl implements Coffe {

    private final static int BASIC_COFFEE_PRICE = 50;

    public int getPrice() {
        System.out.println("Price for basic coffe "+BASIC_COFFEE_PRICE);
        return BASIC_COFFEE_PRICE;
    }
}
