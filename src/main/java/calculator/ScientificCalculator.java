package calculator;

import calculator.Operator.UnaryOperator.AcosOperator;
import calculator.Operator.UnaryOperator.CosOperator;
import calculator.Operator.UnaryOperator.SinOperator;
import calculator.Operator.UnaryOperator.TanOperator;
import calculator.Operator.OperatorType;

public class ScientificCalculator extends ArithmeticCalculator{

    @Override
    public void initOperators(){
        super.initOperators();
        operatorParser.addOperator("sin", OperatorType.SIN, new SinOperator())
                .addOperator("cos", OperatorType.COS, new CosOperator())
                .addOperator("tan", OperatorType.TAN, new TanOperator())
                .addOperator("acos", OperatorType.ACOS, new AcosOperator());
    }

}
