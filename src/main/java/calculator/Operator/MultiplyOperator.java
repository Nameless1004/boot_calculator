package calculator.Operator;

public class MultiplyOperator implements Operatable {

    @Override
    public <T extends Number> double operate(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }
}