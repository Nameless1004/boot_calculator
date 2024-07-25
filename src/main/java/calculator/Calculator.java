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

    // calculate를 추상함수로 만들려했었는데 원넓이 계산기와 사칙연산계산기의 피연산자 수가 달라서 실패했는데
    // 이를 해결하기 위해 setOperands에서 가변인자를 통해 각각 다른 피연산자 개수에 대해 처리를 해주었고 그 후에
    // calculate() 함수를 추상 함수로 만들었습니다.
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
