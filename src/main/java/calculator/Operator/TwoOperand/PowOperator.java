package calculator.Operator.TwoOperand;

public class PowOperator implements TwoOperandOpertor {
    @Override
    public double operate(double a, double b) {
        return Math.pow(a, b);
    }
}
