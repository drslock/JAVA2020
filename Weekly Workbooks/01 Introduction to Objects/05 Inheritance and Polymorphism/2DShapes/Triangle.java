public class Triangle extends TwoDimensionalShape {
    
    float lenA, lenB, lenC;

    public Triangle(float lenA,float lenB,float lenC) {
        super("Triangle");
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
    
    public float calcArea(){
        float sp;
        float area;
        sp = (this.lenA+this.lenB+this.lenC)/2;
        area = (float) Math.sqrt((double) sp*(sp-this.lenA)*(sp-this.lenB)*(sp-this.lenC));
        
        return area;
    }
    public float calcPerimeter() {return lenA+lenB+lenC;}

    void description() {
        System.out.println("This is a Triangle with an Area: " + this.calcArea() +
                            " and Perimeter: " + this.calcPerimeter());
    }


}
