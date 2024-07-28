package calculator.Operator.BinaryOperator;

import calculator.Operator.Operator;

public abstract class BinaryOperator implements Operator {
    public double operate(double a){
        throw new UnsupportedOperationException("Binary operation requires two operands");
    }
    public abstract double operate(double a, double b);
}
