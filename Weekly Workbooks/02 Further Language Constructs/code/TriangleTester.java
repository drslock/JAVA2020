class TriangleTester {
    public static void main(String[] args) {
        // Tricky bit of code to check that assertions have been enabled !
        boolean assertionsEnabled = false;
        assert(assertionsEnabled = true);
        if (assertionsEnabled) {
            testEquilateral();
            testIsosceles();
            testScalene();
            testFlat();
            testRight();
            testImpossible();
            testZero();
            testNegative();
            testOverflow();
            System.out.println("SUCCESS: All tests passed !!!");
        }
        else {
            System.out.println("You MUST run java with assertions enabled (-ea) to test your program !");
        }
    }

    // Equilateral: all equal
    private static void testEquilateral() {
        checkShapeVariant(new Triangle(8, 8, 8), TriangleVariant.EQUILATERAL);
    }

    // Isosceles: any two equal
    private static void testIsosceles() {
        checkShapeVariant(new Triangle(5, 5, 3), TriangleVariant.ISOSCELES);
        checkShapeVariant(new Triangle(5, 3, 5), TriangleVariant.ISOSCELES);
        checkShapeVariant(new Triangle(3, 5, 5), TriangleVariant.ISOSCELES);
        checkShapeVariant(new Triangle(5, 5, 7), TriangleVariant.ISOSCELES);
        checkShapeVariant(new Triangle(5, 7, 5), TriangleVariant.ISOSCELES);
        checkShapeVariant(new Triangle(7, 5, 5), TriangleVariant.ISOSCELES);
    }

    // Scalene: all three different (but not special)
    private static void testScalene() {
        checkShapeVariant(new Triangle(12, 14, 15), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(14, 12, 15), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(12, 15, 14), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(14, 15, 12), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(15, 12, 14), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(15, 14, 12), TriangleVariant.SCALENE);
    }

    // Right-angled: Pythagoras's theorem
    private static void testRight() {
        checkShapeVariant(new Triangle(5, 12, 13), TriangleVariant.RIGHT);
        checkShapeVariant(new Triangle(12, 5, 13), TriangleVariant.RIGHT);
        checkShapeVariant(new Triangle(5, 13, 12), TriangleVariant.RIGHT);
        checkShapeVariant(new Triangle(12, 13, 5), TriangleVariant.RIGHT);
        checkShapeVariant(new Triangle(13, 5, 12), TriangleVariant.RIGHT);
        checkShapeVariant(new Triangle(13, 12, 5), TriangleVariant.RIGHT);
    }

    // Flat: two sides add up to the third
    private static void testFlat() {
        checkShapeVariant(new Triangle(7, 7, 14), TriangleVariant.FLAT);
        checkShapeVariant(new Triangle(7, 14, 7), TriangleVariant.FLAT);
        checkShapeVariant(new Triangle(14, 7, 7), TriangleVariant.FLAT);
        checkShapeVariant(new Triangle(7, 9, 16), TriangleVariant.FLAT);
        checkShapeVariant(new Triangle(7, 16, 9), TriangleVariant.FLAT);
        checkShapeVariant(new Triangle(9, 16, 7), TriangleVariant.FLAT);
        checkShapeVariant(new Triangle(16, 7, 9), TriangleVariant.FLAT);
    }

    // Impossible: two sides add up to less than the third
    private static void testImpossible() {
        checkShapeVariant(new Triangle(2, 3, 13), TriangleVariant.IMPOSSIBLE);
        checkShapeVariant(new Triangle(2, 13, 3), TriangleVariant.IMPOSSIBLE);
        checkShapeVariant(new Triangle(13, 2, 3), TriangleVariant.IMPOSSIBLE);
    }

    // Illegal: a side is zero
    private static void testZero() {
        checkShapeVariant(new Triangle(0, 0, 0), TriangleVariant.ILLEGAL);
        checkShapeVariant(new Triangle(0, 10, 12), TriangleVariant.ILLEGAL);
        checkShapeVariant(new Triangle(10, 0, 12), TriangleVariant.ILLEGAL);
        checkShapeVariant(new Triangle(10, 12, 0), TriangleVariant.ILLEGAL);
    }

    // Illegal: a side is negative
    private static void testNegative() {
        checkShapeVariant(new Triangle(-1, -1, -1), TriangleVariant.ILLEGAL);
        checkShapeVariant(new Triangle(-1, 10, 12), TriangleVariant.ILLEGAL);
        checkShapeVariant(new Triangle(10, -1, 12), TriangleVariant.ILLEGAL);
        checkShapeVariant(new Triangle(10, 12, -1), TriangleVariant.ILLEGAL);
    }

    // Overflow: check that the program doesn't have overflow problems due to
    // using int, float or double. If there are overflow problems, the program will not say Scalene.
    private static void testOverflow() {
        checkShapeVariant(new Triangle(1100000000, 1705032704, 1805032704), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(2000000001, 2000000002, 2000000003), TriangleVariant.SCALENE);
        checkShapeVariant(new Triangle(150000002, 666666671, 683333338), TriangleVariant.SCALENE);
    }

    private static void checkShapeVariant(MultiVariantShape shape, TriangleVariant expectedType) {
        assert(shape.getVariant() == expectedType): "\nERROR: failed to classify " + shape.toString() + " as " + expectedType;
    }
}
