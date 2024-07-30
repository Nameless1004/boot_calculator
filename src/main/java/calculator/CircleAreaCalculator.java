package calculator;

import calculator.Operator.Operator;
import calculator.Operator.OperatorParser;
import calculator.Operator.OperatorType;
import calculator.recorder.Recordable;

import java.util.Scanner;

public class CircleAreaCalculator extends AbstractCalculator {

    double radius;

    public CircleAreaCalculator(OperatorParser operatorParser, Scanner scanner) {
        super(operatorParser, scanner);
    }

    @Override
    public void input() throws Exception {
        System.out.print("반지름을 입력하세요: ");
        Number radius = NumberParser.parse(scanner.nextLine());
        this.radius = radius.doubleValue();
    }

    @Override
    public Number calculate() {
        double result = operatable.operate(radius);

        return result;
    }

    @Override
    public AbstractCalculator addSupportOperator(String code, OperatorType type, Operator operator){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
