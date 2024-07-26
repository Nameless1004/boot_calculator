package calculator.Operator.OneOperand;

public class SinOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.sin(a);
    }
}
