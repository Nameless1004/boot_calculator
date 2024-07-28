package calculator.Operator.UnaryOperator;

public class CircleAreaOperator extends UnaryOperator {
    @Override
    public double operate(double a) {
        return Math.PI * Math.pow(a, 2);
    }
}
