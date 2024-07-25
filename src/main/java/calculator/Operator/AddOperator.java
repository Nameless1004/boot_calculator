package calculator.Operator;

public class AddOperator implements Operatable{
    @Override
    public  <T extends Number> double operate(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}
