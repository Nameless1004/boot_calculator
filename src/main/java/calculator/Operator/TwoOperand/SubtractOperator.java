package calculator.Operator.TwoOperand;

public class SubtractOperator implements TwoOperandOpertor {

    @Override
    public double operate(double a, double b) {
        return a - b;
    }
}