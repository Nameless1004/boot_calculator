package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class ResultRecorder {
    public ResultRecorder() {
        queue = new LinkedList<>();
    }

    private Number recordedNum;
    private Queue<Number> queue;

    public void record(Number num){
        if(num.doubleValue() % 1 ==0.0){
            recordedNum = num.intValue();
            queue.offer(num.intValue());
        }
        else{
            recordedNum = num;
            queue.offer(num);
        }
    }

    public void remove(){
        queue.poll();
    }

    public Stream<Number> stream(){
        return queue.stream();
    }

    public List<Number> getResultList(){
        return stream().toList();
    }

    public Number getLatestResult() {
        return recordedNum;
    }
}
