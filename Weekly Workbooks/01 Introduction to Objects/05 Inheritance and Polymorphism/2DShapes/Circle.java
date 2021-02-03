public class Circle extends TwoDimensionalShape {

    float radius;

    public Circle(float radius) {
        super("Circle");
        this.radius = radius;
    }

    float diameter() {
        return radius * 2;
    }

    float calcArea() {
        return (float) Math.PI * (float) Math.pow(this.radius,2);
    }

    float calcPerimeter() {
        float perm;
        perm = 2 * this.radius * (float) Math.PI;
        return perm;
    }

    void description() {
        System.out.println("This is a Circle with an Area: " + this.calcArea() +
                            " and Perimeter: " + this.calcPerimeter());
    }
}    