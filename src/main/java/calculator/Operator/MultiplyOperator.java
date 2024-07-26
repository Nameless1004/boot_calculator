package calculator.Operator;

public class MultiplyOperator implements Operatable {

    @Override
    public double operate(double a, double b) {
        return a * b;
    }
}