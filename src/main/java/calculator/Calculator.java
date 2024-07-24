package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public Calculator(){
        calcResults = new LinkedList<>();
        circleAreacalcResults = new LinkedList<>();
    }

    // 파이는 변하지 않는 상수값이여서 static final로 하였습니다.
    private static final float PI = 3.14159265359f;

    private Queue<Integer> calcResults;
    private Queue<Float> circleAreacalcResults;

    public Queue<Float> getCircleAreaCalcResults() { return circleAreacalcResults; }
    public void setCircleAreaCalcResults(Queue<Float> q) {this.circleAreacalcResults = q; }

    private int result = 0;
    public int getResult(){ return result; }
    public void setResult(int result){ this.result = result; }

    public float calculateCircleArea(float radius){
        var res = PI * radius * radius;
        circleAreacalcResults.add(res);
        return res;
    }

    public int calculate(int firstNum, int secondNum, char op) throws Exception{
        switch (op) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum == 0) {
                    // 매개변수로 오류 내용을 보낸다는 말이 이해가 되지 않아 호출한 곳으로 throw 했습니다.
                    throw new ArithmeticException("분모가 0이 될 수 없습니다.");
                }
                result = firstNum / secondNum;
                break;
            default:
                throw new Exception("+ - * / 중 하나를 입력해주세요.");
        }

        calcResults.add(result);
        return result;
    }

    public void inquiryResults(){
        calcResults.forEach(System.out::println);
    }
    
    // 원 넓이 조회
    public void inquiryCircleAreaResults(){
        circleAreacalcResults.forEach(System.out::println);
    }

    public void removeResult() {
        calcResults.poll();
    }
}
