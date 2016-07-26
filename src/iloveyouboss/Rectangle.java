package iloveyouboss;

public class Rectangle {
    private final Point origin;
    private Point opposite;

    public Rectangle(Point origin, Point opposite) {
        this.origin = origin;
        this.opposite = opposite;
    }
    public Rectangle(Point origin) { this.origin = origin; }

    public Point origin() { return origin; }
    public Point opposite() { return opposite; }
    public int area() {
        return (opposite.x - origin.x) * (opposite.y - origin.y);
    }
    public void setOppositeCorner(Point opposite) { this.opposite = opposite; }
}
