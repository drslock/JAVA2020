public class Triangle {
    
    float lenA, lenB, lenC;

    public Triangle(float lenA,float lenB,float lenC) {

        this.lenA = lenA;
        this.lenB = lenB;
        this.lenC = lenC;
    }
    
    float longestSide() {
        float lngSide;
        lngSide = this.lenA;

        if(lngSide<=this.lenB){lngSide = this.lenB;}
        if(lngSide<=this.lenC){lngSide = this.lenC;}

        return lngSide;

    }

    String description() {

        return "The longest side of the triangle " + (int) this.longestSide();

    }

    public static void main(String[] args) {
        Triangle testTriangle = new Triangle(2,5,9);
        int longestSide = (int) testTriangle.longestSide();
        System.out.println("The longest side of the triangle is " + longestSide);
        System.out.println(testTriangle.description());
    }

}
