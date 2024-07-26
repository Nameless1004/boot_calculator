package calculator.Operator.OneOperand;

public class TanOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.tan(a);
    }
}
