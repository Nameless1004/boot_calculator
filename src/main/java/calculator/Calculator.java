package calculator;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator {
    public Calculator() {
        recorder = new ResultRecorder<>();
    }

    // 파이는 변하지 않는 상수값이여서 static final로 하였습니다.
    protected static final double PI = 3.14159265359;

    protected ResultRecorder<Number> recorder;


    public Number getResult() {
        return recorder.getLatestResult();
    }


    public void inquiryResults() {
        recorder.stream().forEach(System.out::println);
    }


    public void removeResult() {
        recorder.remove();
    }

}
