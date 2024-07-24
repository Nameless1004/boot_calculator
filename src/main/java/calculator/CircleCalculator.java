package calculator;

import java.util.LinkedList;

public class CircleCalculator extends Calculator{
    public double calculateCircleArea(double radius){
        var res = PI * radius * radius;
        recorder.record(res);
        return res;
    }
}
