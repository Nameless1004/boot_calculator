package calculator.Operator.UnaryOperator;

import calculator.Operator.Operator;

public abstract class UnaryOperator implements Operator {
    public double operate(double a, double b){
        throw new UnsupportedOperationException("\"Binary operation requires one operands");
    }
    public abstract double operate(double a);
}
