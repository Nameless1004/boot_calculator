package calculator.Operator.BinaryOperator;

public class DivideOperator extends BinaryOperator {

    @Override
    public double operate(double a, double b)  throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
        return a/b;
    }
}