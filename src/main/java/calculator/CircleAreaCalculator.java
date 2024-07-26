package calculator;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CircleAreaCalculator extends Calculator {
    double radius;
    @Override
    public void input() throws Exception {
        System.out.print("반지름을 입력하세요: ");
        Number radius = NumberParser.parse(scanner.nextLine());

        this.radius = radius.doubleValue();
    }

    @Override
    public Number calculate() {
        double result = radius * radius * Math.PI;
        resultRecorder.record(result);
        return resultRecorder.getLatestResult();
    }
}
