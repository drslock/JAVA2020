class Rectangle extends TwoDimensionalShape {
    int width;
    int height;

    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }

    double calculateArea() {
        return width * height;
    }

    int calculatePerimeterLength() {
        return 2 * (width + height);
    }

    public String toString() {
        return "Rectangle of dimensions " + width + " x " + height;
    }
}
