package calculator;

public class CircleCalculator extends Calculator {

    @Override
    public void calculate(Object... input) throws Exception {
        if (input.length != 1 || !(input[0] instanceof Double)) {
            throw new Exception("원 넓이를 구하려면 피연산자(double) 1개를 입력하세요.");
        }
        double radius = ((Double) input[0]).doubleValue();
        double res = Calculator.PI * radius * radius;
        recorder.record(res);
    }
}
