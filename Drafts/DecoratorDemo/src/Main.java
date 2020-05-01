public class Main {
    public static void main(String[] args) {
        Coffe c = new CoffeImpl();

        Coffe cm = new MilkDecorator(c);

        System.out.println(cm.getPrice());

        Coffe cs = new SugarDecorator(c);

        System.out.println(cs.getPrice());

        Coffe msc = new MilkDecorator(new SugarDecorator(new CoffeImpl()));

        System.out.println(msc.getPrice());

        Coffe smc = new SugarDecorator(new MilkDecorator(new CoffeImpl()));

        System.out.println(smc.getPrice());

    }
}
