package calculator;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CircleAreaCalculator extends Calculator {

    @Override
    public void onUpdate() throws Exception {
        System.out.print("반지름을 입력하세요: ");
        Number radius = NumberParser.parse(scanner.nextLine());

        double result = calculate(radius).doubleValue();
        resultRecorder.record(result);

        System.out.println("결과 : " + result);

        System.out.println("--- 결과물들 출력 ---");
        inquiryResults();
    }


    @Override
    protected Number calculate(Number num) {
        double radius = num.doubleValue();
        return radius * radius * Math.PI;
    }
}
