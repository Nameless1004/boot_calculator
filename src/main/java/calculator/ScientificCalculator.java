package calculator;

import calculator.Operator.OneOperand.AcosOperator;
import calculator.Operator.OneOperand.CosOperator;
import calculator.Operator.OneOperand.SinOperator;
import calculator.Operator.OneOperand.TanOperator;
import calculator.Operator.OperatorType;

public class ScientificCalculator extends ArithmeticCalculator{
    public ScientificCalculator() {
        operatorParser.addOperator("sin", OperatorType.SIN, new SinOperator());
        operatorParser.addOperator("cos", OperatorType.COS, new CosOperator());
        operatorParser.addOperator("tan", OperatorType.TAN, new TanOperator());
        operatorParser.addOperator("acos", OperatorType.ACOS, new AcosOperator());
    }
}
