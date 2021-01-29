class Circle extends TwoDimensionalShape {
    int radius;

    public Circle(int r) {
        radius = r;
    }

    double calculateArea() {
        return (int)Math.round(Math.PI * radius * radius);
    }

    int calculatePerimeterLength() {
        return (int)Math.round(Math.PI * radius * 2.0);
    }

    public String toString() {
        return "Circle with radius " + radius;
    }
}
