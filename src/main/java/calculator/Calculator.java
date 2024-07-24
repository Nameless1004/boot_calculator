package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public Calculator(){
        queue = new LinkedList<>();
    }
    private Queue<Integer> queue;

    private int result = 0;
    public int getResult(){ return result; }
    public void setResult(int result){ this.result = result; }


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

        queue.add(result);
        return result;
    }

    public void inquiryResults(){
        queue.forEach(System.out::println);
    }

    public void removeResult() {
        queue.poll();
    }
}
