public class Rectangle extends Shape {
    private double a, b;

    public Rectangle(double a, double b) {
        super("rectangle");
        this.a = a;
        this.b = b;
    }

    @Override
    double calculateSquare() {
        return a*b;
    }
}
