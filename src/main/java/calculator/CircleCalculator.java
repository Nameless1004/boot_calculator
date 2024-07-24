package calculator;

import java.util.LinkedList;

public class CircleCalculator extends Calculator{
    public double calculateCircleArea(double radius){
        var res = PI * radius * radius;
        calcResults.add(res);
        return res;
    }
}
