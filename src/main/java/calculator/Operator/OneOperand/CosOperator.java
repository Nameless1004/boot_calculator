package calculator.Operator.OneOperand;

public class CosOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.cos(a);
    }
}
