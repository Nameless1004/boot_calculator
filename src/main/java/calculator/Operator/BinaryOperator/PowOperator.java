package calculator.Operator.BinaryOperator;

public class PowOperator extends BinaryOperator {
    @Override
    public double operate(double a, double b) {
        return Math.pow(a, b);
    }
}
