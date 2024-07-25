package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class ResultRecorder<T extends Number> {
    public ResultRecorder() {
        queue = new LinkedList<>();
    }

    private T recordedNum;
    private Queue<T> queue;

    public void record(T num){
        recordedNum = num;
        queue.offer(num);
    }

    public void remove(){
        queue.remove();
    }

    public Stream<T> stream(){
        return queue.stream();
    }

    public List<T> getResultList(){
        return stream().toList();
    }

    public T getLatestResult() {
        return recordedNum;
    }
}
