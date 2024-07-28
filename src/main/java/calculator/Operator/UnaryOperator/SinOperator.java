package calculator.Operator.UnaryOperator;

public class SinOperator extends UnaryOperator {
    @Override
    public double operate(double a) {
        return Math.sin(a);
    }
}
