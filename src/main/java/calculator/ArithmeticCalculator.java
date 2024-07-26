package calculator;

import calculator.Operator.*;
import calculator.Operator.OneOperand.OneOperandOperator;
import calculator.Operator.TwoOperand.*;

public class ArithmeticCalculator extends AbstractCalculator {
    private Number firstNumber;
    private Number secondNumber;
    private Operator operatable;
    protected OperatorParser operatorParser;

    public ArithmeticCalculator() {
        operatorParser = new OperatorParser();
        operatorParser.addOperator("+", OperatorType.ADD, new AddOperator());
        operatorParser.addOperator("-", OperatorType.SUB, new SubtractOperator());
        operatorParser.addOperator("*", OperatorType.MUL, new MultiplyOperator());
        operatorParser.addOperator("/", OperatorType.DIV, new DivideOperator());
        operatorParser.addOperator("%", OperatorType.MOD, new ModOperator());
        operatorParser.addOperator("^", OperatorType.MOD, new PowOperator());
    }

    @Override
    public void input() throws Exception {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        firstNumber = NumberParser.parse(scanner.nextLine());

        System.out.print(operatorParser.toString() + "를 입력하세요: ");
        String op = scanner.nextLine();
        operatable = operatorParser.parse(op);

        if(operatable instanceof TwoOperandOpertor){
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNumber = NumberParser.parse(scanner.nextLine());
        } else {
            secondNumber = null;
        }
    }

    @Override
    public Number calculate() {
        Number num;
        if(operatable instanceof TwoOperandOpertor){
            num = ((TwoOperandOpertor) operatable).operate(firstNumber.doubleValue(), secondNumber.doubleValue());
        } else {
          num = ((OneOperandOperator) operatable).operate(firstNumber.doubleValue());
        }

        resultRecorder.record(num);
        return resultRecorder.getLatestResult();
    }


}
