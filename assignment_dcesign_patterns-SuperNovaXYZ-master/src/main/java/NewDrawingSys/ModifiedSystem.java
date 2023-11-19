package NewDrawingSys;

// Shape interface
interface Shape {
    void draw(int x1, int y1, int x2, int y2);
}

// Rectangle class
class Rectangle {
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        // Implement code to draw a rectangle
        System.out.println("Drawing a rectangle with coordinates: " +
                "(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")");
    }
}

// Circle class
class Circle {
    public void draw(int x1, int y1, int r) {
        System.out.println("Circle from center (" + x1 + "," + y1 + "), with radius(" + r + ")");
    }
}

// RectangleAdapter class
class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        rectangle.drawRectangle(x1, y1, x2, y2);
    }
}

// CircleAdapter class
class CircleAdapter implements Shape {
    private Circle circle;

    public CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        int radius = Math.abs(x2 - x1);
        circle.draw(x1, y1, radius);
    }
}

public class ModifiedSystem {
    public static void main(String[] args) {
        Shape[] shapes = {
                new RectangleAdapter(new Rectangle()),
                new CircleAdapter(new Circle()),
        };

        int x1 = 10, y1 = 20;
        int x2 = 30, y2 = 60;

        for (Shape shape : shapes) {
            shape.draw(x1, y1, x2, y2);
        }
    }
}
