package calculator.recorder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class ResultRecorder implements Recordable<Number> {

    private final Queue<Number> queue;
    private Number latestResult;

    public ResultRecorder() {
        queue = new LinkedList<>();
    }

    @Override
    public Collection<Number> getRecordCollection() {
        return queue;
    }

    @Override
    public void record(Number num) {
        // 기록할 때 결과값이 정수이면 정수로 저장 아니면 실수로 저정합니다.
        if (num.doubleValue() % 1 == 0.0) {
            latestResult = num.intValue();
            queue.offer(num.intValue());
        } else {
            latestResult = num;
            queue.offer(num);
        }
    }

    @Override
    public void remove() {
        queue.poll();
    }

    @Override
    public Stream<Number> stream() {
        return queue.stream();
    }

    @Override
    public Number getLatestResult() {
        return latestResult;
    }

}
