package calculator.Operator;

public class SubtractOperator implements Operatable {

    @Override
    public double operate(double a, double b) {
        return a - b;
    }
}