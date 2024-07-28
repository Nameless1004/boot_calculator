package calculator;

import calculator.Operator.UnaryOperator.CircleAreaOperator;
import calculator.Operator.UnaryOperator.UnaryOperator;

public class CircleAreaCalculator extends AbstractCalculator {

    double radius;

    public CircleAreaCalculator() {
        initOperators();
    }

    @Override
    public void initOperators() {
        operatable = new CircleAreaOperator();
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
        resultRecorder.record(result);
        return resultRecorder.getLatestResult();
    }
}
