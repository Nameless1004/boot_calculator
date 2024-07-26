package calculator.Operator.OneOperand;

public class AcosOperator implements OneOperandOperator {
    @Override
    public double operate(double a) {
        return Math.acos(a);
    }
}
