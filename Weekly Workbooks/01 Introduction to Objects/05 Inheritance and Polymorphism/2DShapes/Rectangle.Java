public class Rectangle extends TwoDimensionalShape {
    
    float longSide, shortSide;

    public Rectangle(float longSide, float shortSide) {
        super("Rectangle");
        this.longSide = longSide;
        this.shortSide = shortSide;
    }

    float calcArea() {
        return shortSide * longSide;
    }

    float calcPerimeter() {
        return 2 * shortSide + 2 * longSide;
    }

    void description() {
        System.out.println("This is a rectangle with an Area: " + this.calcArea() +
                            " and Perimeter: " + this.calcPerimeter());
    }

}

