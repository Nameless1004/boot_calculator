package calculator.Operator.TwoOperand;

import calculator.Operator.TwoOperandOpertor;

public class PowOperator implements TwoOperandOpertor {
    @Override
    public double operate(double a, double b) {
        return Math.pow(a, b);
    }
}
