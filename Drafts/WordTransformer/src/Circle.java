public class Circle extends Shape {
    private static double PI = 3.14;

    private double r;

    public Circle(double r) {
        super("circle");
        this.r = r;
    }

    @Override
    double calculateSquare() {
        return PI*r*r;
    }
}
