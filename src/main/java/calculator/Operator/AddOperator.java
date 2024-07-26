package calculator.Operator;

public class AddOperator implements Operatable {

    @Override
    public double operate(double a, double b) {
        return a + b;
    }
}
