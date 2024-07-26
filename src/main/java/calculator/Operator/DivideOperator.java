package calculator.Operator;

public class DivideOperator implements Operatable {

    @Override
    public <T extends Number> double operate(T a, T b) throws ArithmeticException {
        if (b.doubleValue() == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
        return a.doubleValue() / b.doubleValue();
    }
}