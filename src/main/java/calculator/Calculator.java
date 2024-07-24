package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public Calculator(){
        calcResults = new LinkedList<>();
    }

    // 파이는 변하지 않는 상수값이여서 static final로 하였습니다.
    protected static final double PI = 3.14159265359;

    protected Queue<Double> calcResults;
    public Queue<Double> getCalcResults() { return calcResults; }

    protected double result = 0;
    public double getResult(){ return result; }
    public void setResult(double result){ this.result = result; }



    public void inquiryResults(){
        calcResults.forEach(System.out::println);
    }


    public void removeResult() {
        calcResults.poll();
    }
}
