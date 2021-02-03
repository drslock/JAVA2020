
public class TwoDimensionalShape {

    String name;
    int sideNum;

    public TwoDimensionalShape(String name) {
        this.name = name;
    }

    public TwoDimensionalShape(int sideNum) {
        this.sideNum = sideNum;
    }

    float calcArea() {return -1;}
    float calcPerimeter() {return -1;}

    void description() {
        System.out.println("This object is flat and contains a set number "
                                + "of vertices");
    }

    String getName() {
        return this.name;
    }
    
}






