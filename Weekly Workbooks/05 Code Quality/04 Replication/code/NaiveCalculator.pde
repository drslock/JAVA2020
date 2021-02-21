import java.util.*;

void setup()
{
  Calculator calculator = new Calculator();
  System.out.println("10 + 5 = " + calculator.calculateThis("10 + 5"));
  System.out.println("22 - 7 = " + calculator.calculateThis("22 - 7"));
  System.out.println("7 * 9 = " + calculator.calculateThis("7 * 9"));
  System.out.println("44 / 3 = " + calculator.calculateThis("44 / 3"));
  System.out.println("sqrt 27 = " + calculator.calculateThis("sqrt 27"));
  System.out.println("5 sq = " + calculator.calculateThis("5 sq"));
  System.out.println("sin 26 = " + calculator.calculateThis("sin 26"));
  System.out.println("cos 33 = " + calculator.calculateThis("cos 33"));
  System.out.println("tan 19 = " + calculator.calculateThis("tan 19"));
  System.out.println("tan tan = " + calculator.calculateThis("tan tan"));
}

class Calculator
{
  public float calculateThis(String input)
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
        return sqrt(firstOperand);
      } else return Float.NaN;
    } else if (input.contains("sq")) {
      if (isNumber(tokens[0])) {
        float firstOperand = Float.parseFloat(tokens[0]);
        return firstOperand * firstOperand;
      } else return Float.NaN;
    } else if (input.contains("sin")) {
      if (isNumber(tokens[1])) {
        float firstOperand = Float.parseFloat(tokens[1]);
        return sin(firstOperand);
      } else return Float.NaN;
    } else if (input.contains("cos")) {
      if (isNumber(tokens[1])) {
        float firstOperand = Float.parseFloat(tokens[1]);
        return cos(firstOperand);
      } else return Float.NaN;
    } else if (input.contains("tan")) {
      if (isNumber(tokens[1])) {
        float firstOperand = Float.parseFloat(tokens[1]);
        return tan(firstOperand);
      } else return Float.NaN;
    } else return Float.NaN;
  }
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
