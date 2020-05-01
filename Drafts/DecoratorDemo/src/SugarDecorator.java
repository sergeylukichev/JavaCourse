public class SugarDecorator extends AbstractDecorator {

    private final static int SUGAR_PRICE = 5;

    public SugarDecorator(Coffe coffe) {
        super(coffe);
    }

    public int getPrice() {
        int price = super.getPrice() + SUGAR_PRICE;
        System.out.println("Price for coffe with Sugar "+price);

        return price;
    }

}
