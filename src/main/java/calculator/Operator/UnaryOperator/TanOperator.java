package calculator.Operator.UnaryOperator;

public class TanOperator extends UnaryOperator {
    @Override
    public double operate(double a) {
        return Math.tan(a);
    }
}
