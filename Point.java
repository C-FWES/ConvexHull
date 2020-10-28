package ConvexHull;

public class Point {
    private double x;
    private double y;
    private String name;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String toString() {
        return name + "(" + x + ", " + y + ")";
    }
}
