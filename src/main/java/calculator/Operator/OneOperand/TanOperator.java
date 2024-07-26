package calculator.Operator.OneOperand;

import calculator.Operator.OneOperandOperator;

public class TanOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.tan(a);
    }
}
