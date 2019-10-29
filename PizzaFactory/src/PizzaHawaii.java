public class PizzaHawaii extends Pizza {
    private static String TYPE = "Pizza Hawaii";

    public PizzaHawaii() {
        super(TYPE);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Pizza with Ananas and Cheese");
    }
}
