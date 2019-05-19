public class Main {
    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();

        String s = "PIZZA_SALAMI";

        PizzaType pizzaType = PizzaType.valueOf(s);

        Pizza pizza = factory.createPizza(pizzaType);

        String s2 = "PIZZA_DIABLO";
        PizzaType pizzaType1 = PizzaType.valueOf(s2);
        Pizza pizza1 = factory.createPizza(pizzaType1);

        Pizza pizza2 = factory.createPizza(PizzaType.PIZZA_MOZARELLA);

        pizza.orderPizza();
        pizza1.orderPizza();
        pizza2.orderPizza();

    }
}
