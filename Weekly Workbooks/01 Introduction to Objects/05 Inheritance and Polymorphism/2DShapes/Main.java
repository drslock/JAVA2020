public class Main {

    public static void main(String[] args) {
        TwoDimensionalShape shape = new TwoDimensionalShape("Finger");
        System.out.println(shape.getName());
        shape.description();

        Circle newCircle = new Circle(10);
        newCircle.description();

        Triangle newTriangle = new Triangle(2,4,5);
        newTriangle.description();

    }
    
}
