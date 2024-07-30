package calculator;

public class CircleAreaCalculator extends AbstractCalculator {

    double radius;

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
