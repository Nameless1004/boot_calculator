package calculator.Operator.OneOperand;

import calculator.Operator.OneOperandOperator;

public class SinOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.sin(a);
    }
}
