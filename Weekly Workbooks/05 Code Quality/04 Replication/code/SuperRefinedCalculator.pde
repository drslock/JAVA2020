import java.util.*;

void setup()
{
  Calculator calculator = new Calculator();
  String[] calculations = {"10 + 5", "22 - 7", "7 * 9", "44 / 3", "sqrt 27", "5 sq", "sin 26", "cos 33", "tan 19", "tan tan"};
  for (String next : calculations) System.out.println(next + " = " + calculator.calculateThis(next));
}

class Calculator
{
  HashMap<String, Operator> allAvailableOperations = new HashMap<String, Operator>();

  public Calculator()
  {
    allAvailableOperations.put("+", new Adder());
    allAvailableOperations.put("-", new Subtractor());
    allAvailableOperations.put("/", new Divider());
    allAvailableOperations.put("*", new Multiplier());
    allAvailableOperations.put("sq", new Squarer());
    allAvailableOperations.put("sqrt", new SquareRooter());
    allAvailableOperations.put("sin", new Siner());
    allAvailableOperations.put("cos", new Cosiner());
    allAvailableOperations.put("tan", new Taner());
  }

  public float calculateThis(String input)
  {
    float result = Float.NaN;
    String[] tokens = input.split(" ");
    for (String token : tokens) {
      Operator operator = allAvailableOperations.get(token);
      if (operator != null) result = operator.performCheckedCalculation(tokens);
    }
    return result;
  }
}

abstract class Operator
{  
  protected abstract float performUncheckedCalculation(String[] tokens);

  public float performCheckedCalculation(String[] tokens)
  {
    try { 
      return performUncheckedCalculation(tokens);
    }
    catch (NumberFormatException e) { 
      return Float.NaN;
    }
  }
}

////////////////////////////////////////////////////////////////////////////////////////////
// The following are a bunch of subclasses that actually perform the different operations //
////////////////////////////////////////////////////////////////////////////////////////////

class Adder extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return Float.parseFloat(tokens[0]) + Float.parseFloat(tokens[2]);
  }
}

class Subtractor extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return Float.parseFloat(tokens[0]) - Float.parseFloat(tokens[2]);
  }
}

class Divider extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return Float.parseFloat(tokens[0]) / Float.parseFloat(tokens[2]);
  }
}

class Multiplier extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return Float.parseFloat(tokens[0]) * Float.parseFloat(tokens[2]);
  }
}

class Squarer extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return Float.parseFloat(tokens[0]) * Float.parseFloat(tokens[0]);
  }
}

class SquareRooter extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return sqrt(Float.parseFloat(tokens[1]));
  }
}

class Siner extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return sin(Float.parseFloat(tokens[1]));
  }
}

class Cosiner extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return cos(Float.parseFloat(tokens[1]));
  }
}

class Taner extends Operator {
  protected float performUncheckedCalculation(String[] tokens) {
    return tan(Float.parseFloat(tokens[1]));
  }
}
