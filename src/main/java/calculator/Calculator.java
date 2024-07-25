package calculator;

import calculator.Operator.Operatable;
import calculator.Operator.OperatorParser;

import java.util.function.Predicate;

public abstract class Calculator {
    public Calculator() {
        recorder = new ResultRecorder();
        opParser = new OperatorParser();
    }

    // 파이는 변하지 않는 상수값이여서 static final로 하였습니다.
    protected static final double PI = 3.14159265359;
    protected ResultRecorder recorder;
    protected OperatorParser opParser;
    public abstract void setOperator(Operatable operator);

    // 원을 구하는 계산기와 그냥 계산기를 필요한 피연산자 개수가 달라서 추상화를 못해서
    // calculate()를 추상함수로 만들고 setOperands에서 가변인자를 통해 각각 처리를 해주었습니다.
    public abstract void setOperands(Number... nums) throws Exception;

    public abstract void calculate() throws Exception;

    // 가장 최근 결과를 가져옵니다.
    public Number getResult() {
        return recorder.getLatestResult();
    }

    public void inquiryResults() {
        recorder.stream().forEach(System.out::println);
    }

    // 람다식으로 조건을 받고 stream()의 filter를 사용해 필터링을 해주었습니다.
    public void inquiryFiltering(Predicate<Number> predicate) {
        recorder.stream().filter(predicate).forEach(System.out::println);
    }

    public void removeResult() {
        recorder.remove();
    }

}
