package calculator.Operator.TwoOperand;

public class MultiplyOperator implements TwoOperandOpertor {

    @Override
    public double operate(double a, double b) {
        return a * b;
    }
}