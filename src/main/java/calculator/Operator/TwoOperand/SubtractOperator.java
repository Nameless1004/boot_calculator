package calculator.Operator.TwoOperand;

import calculator.Operator.TwoOperandOpertor;

public class SubtractOperator implements TwoOperandOpertor {

    @Override
    public double operate(double a, double b) {
        return a - b;
    }
}