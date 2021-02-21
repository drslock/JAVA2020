import java.util.*;

class NaiveCalculator
{
    public float calculateResult(String input)
    {
        String[] tokens = input.split(" ");
        if (input.contains("+")) {
            if (isNumber(tokens[0]) && isNumber(tokens[2])) {
                float firstOperand = Float.parseFloat(tokens[0]);
                float secondOperand = Float.parseFloat(tokens[2]);
                return firstOperand + secondOperand;
            } else return Float.NaN;
        } else if (input.contains("-")) {
            if (isNumber(tokens[0]) && isNumber(tokens[2])) {
                float firstOperand = Float.parseFloat(tokens[0]);
                float secondOperand = Float.parseFloat(tokens[2]);
                return firstOperand - secondOperand;
            } else return Float.NaN;
        } else if (input.contains("*")) {
            if (isNumber(tokens[0]) && isNumber(tokens[2])) {
                float firstOperand = Float.parseFloat(tokens[0]);
                float secondOperand = Float.parseFloat(tokens[2]);
                return firstOperand * secondOperand;
            } else return Float.NaN;
        } else if (input.contains("/")) {
            if (isNumber(tokens[0]) && isNumber(tokens[2])) {
                float firstOperand = Float.parseFloat(tokens[0]);
                float secondOperand = Float.parseFloat(tokens[2]);
                return firstOperand / secondOperand;
            } else return Float.NaN;
        } else if (input.contains("sqrt")) {
            if (isNumber(tokens[1])) {
                float firstOperand = Float.parseFloat(tokens[1]);
                return (float)Math.sqrt(firstOperand);
            } else return Float.NaN;
        } else if (input.contains("sq")) {
            if (isNumber(tokens[0])) {
                float firstOperand = Float.parseFloat(tokens[0]);
                return firstOperand * firstOperand;
            } else return Float.NaN;
        } else if (input.contains("sin")) {
            if (isNumber(tokens[1])) {
                float firstOperand = Float.parseFloat(tokens[1]);
                return (float)Math.sin(firstOperand);
            } else return Float.NaN;
        } else if (input.contains("cos")) {
            if (isNumber(tokens[1])) {
                float firstOperand = Float.parseFloat(tokens[1]);
                return (float)Math.cos(firstOperand);
            } else return Float.NaN;
        } else if (input.contains("tan")) {
            if (isNumber(tokens[1])) {
                float firstOperand = Float.parseFloat(tokens[1]);
                return (float)Math.tan(firstOperand);
            } else return Float.NaN;
        } else return Float.NaN;
    }

    public static boolean isNumber(String possibleNumber)
    {
        try {
            Float.parseFloat(possibleNumber);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args)
    {
        NaiveCalculator calculator = new NaiveCalculator();
        System.out.println("10 + 5 = " + calculator.calculateResult("10 + 5"));
        System.out.println("22 - 7 = " + calculator.calculateResult("22 - 7"));
        System.out.println("7 * 9 = " + calculator.calculateResult("7 * 9"));
        System.out.println("44 / 3 = " + calculator.calculateResult("44 / 3"));
        System.out.println("sqrt 27 = " + calculator.calculateResult("sqrt 27"));
        System.out.println("5 sq = " + calculator.calculateResult("5 sq"));
        System.out.println("sin 26 = " + calculator.calculateResult("sin 26"));
        System.out.println("cos 33 = " + calculator.calculateResult("cos 33"));
        System.out.println("tan 19 = " + calculator.calculateResult("tan 19"));
        System.out.println("tan tan = " + calculator.calculateResult("tan tan"));
    }

}
