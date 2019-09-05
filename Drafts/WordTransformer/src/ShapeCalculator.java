public class ShapeCalculator {

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(10), new Rectangle(5, 10)};

        System.out.println(totalSquare(shapes));
    }
    //circle, rectangle, quadrat
    public static double totalSquare(Shape [] shapes) {
        double ret = 0;
        for(Shape s: shapes) {
            ret += s.calculateSquare();
        }
        return ret;
    }
}
