package calculator.Operator.OneOperand;

import calculator.Operator.OneOperandOperator;

public class CosOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.cos(a);
    }
}
