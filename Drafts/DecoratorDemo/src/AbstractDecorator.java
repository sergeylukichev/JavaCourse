public class AbstractDecorator implements Coffe {

    private Coffe coffe;

    public AbstractDecorator(Coffe coffe) {
        this.coffe = coffe;
    }

    @Override
    public int getPrice() {
        return coffe.getPrice();
    }
}
