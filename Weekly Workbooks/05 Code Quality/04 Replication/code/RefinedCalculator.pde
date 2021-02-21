import java.util.*;

void setup()
{
  Calculator calculator = new Calculator();
  String[] calculations = {"10 + 5", "22 - 7", "7 * 9", "44 / 3", "sqrt 27", "5 sq", "sin 26", "cos 33", "tan 19", "tan tan"};
  for (String next : calculations) System.out.println(next + " = " + calculator.calculateThis(next));
}

class Calculator
{
  public float calculateThis(String input)
  {
    String[] tokens = input.split(" ");
    if (input.contains("+")) return add(tokens[0], tokens[2]);
    else if (input.contains("-")) return subtract(tokens[0], tokens[2]);
    else if (input.contains("*")) return multiply(tokens[0], tokens[2]);
    else if (input.contains("/")) return divide(tokens[0], tokens[2]);
    else if (input.contains("sqrt")) return squareRoot(tokens[1]);
    else if (input.contains("sq")) return square(tokens[0]);
    else if (input.contains("sin")) return sin(tokens[1]);
    else if (input.contains("cos")) return cos(tokens[1]);
    else if (input.contains("tan")) return tan(tokens[1]);
    else return Float.NaN;
  }
}

public float add(String a, String b)
{
  if(isNumber(a) && isNumber(b)) return convertToFloat(a) + convertToFloat(b);
  else return Float.NaN;
}

public float subtract(String a, String b)
{
  if(isNumber(a) && isNumber(b)) return convertToFloat(a) - convertToFloat(b);
  else return Float.NaN;
}

public float divide(String a, String b)
{
  if(isNumber(a) && isNumber(b)) return convertToFloat(a) / convertToFloat(b);
  else return Float.NaN;
}

public float multiply(String a, String b)
{
  if(isNumber(a) && isNumber(b)) return convertToFloat(a) * convertToFloat(b);
  else return Float.NaN;
}

public float squareRoot(String operand)
{
  if(isNumber(operand)) return sqrt(convertToFloat(operand));
  else return Float.NaN;
}


public float square(String operand)
{
  if(isNumber(operand)) return pow(convertToFloat(operand), 2);
  else return Float.NaN;
}

public float sin(String operand)
{
  if(isNumber(operand)) return tan(convertToFloat(operand));
  else return Float.NaN;
}

public float cos(String operand)
{
  if(isNumber(operand)) return tan(convertToFloat(operand));
  else return Float.NaN;
}

public float tan(String operand)
{
  if(isNumber(operand)) return tan(convertToFloat(operand));
  else return Float.NaN;
}

public static boolean isNumber(String possibleNumber)
{ 
  try {  
    convertToFloat(possibleNumber);  
    return true;
  } 
  catch(NumberFormatException e) {  
    return false;
  }
}

public static float convertToFloat(String number)
{
  return Float.parseFloat(number);
}
