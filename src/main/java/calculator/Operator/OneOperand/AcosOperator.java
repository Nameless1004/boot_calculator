package calculator.Operator.OneOperand;

import calculator.Operator.OneOperandOperator;

public class AcosOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.acos(a);
    }
}
