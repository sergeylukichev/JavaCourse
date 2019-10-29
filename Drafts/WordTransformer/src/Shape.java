public abstract class Shape {

    private String displayName;

    public Shape(String displayName) {
        this.displayName = displayName;
    }

    abstract double calculateSquare();

    public String getDisplayName(){
        return displayName;
    }
}
