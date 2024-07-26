package calculator.Operator.TwoOperand;

import calculator.Operator.TwoOperandOpertor;

public class ModOperator implements TwoOperandOpertor {

    @Override
    public double operate(double a, double b) {
        if (b == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
        return a % b;
    }
}
