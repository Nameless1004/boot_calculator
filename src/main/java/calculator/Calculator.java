package calculator;

import java.util.function.Predicate;

public abstract class Calculator {
    public Calculator() {
        recorder = new ResultRecorder();
    }

    // 파이는 변하지 않는 상수값이여서 static final로 하였습니다.
    protected static final double PI = 3.14159265359;
    protected ResultRecorder recorder;

    public abstract void setOperator(char operator);

    public abstract void setOperands(Number... nums) throws Exception;

    public abstract void calculate() throws Exception;

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
