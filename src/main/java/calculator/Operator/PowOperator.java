package calculator.Operator;

public class PowOperator implements Operatable{
    @Override
    public double operate(double a, double b) {
        return Math.pow(a, b);
    }
}
