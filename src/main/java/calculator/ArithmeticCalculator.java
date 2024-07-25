package calculator;
import calculator.Operator.OperatorParser;

import java.util.function.Predicate;

public class ArithmeticCalculator extends Calculator{

    private char opCode;
    private Number first;
    private Number second;
    @Override
    public void setOperator(char operator) {
        opCode = operator;
    }

    @Override
    public void setOperands(Number... nums) throws Exception{
        if(nums.length != 2){
            throw new Exception("필요 피연산자 수는 2개 입니다.");
        }
        first = nums[0];
        second = nums[1];
    }

    @Override
    public void calculate() throws Exception {
        // 인터페이스를 활용한 다형성으로 구현하였습니다.
        // 나누기의 경우 따로 예외를 던지게 하였습니다.

        /*  자바에서 제네릭에는 원시타입이 들어가지 않고, Integer도 받아야하고 Double도 받아야하므로
            상위 클래스인 Number로 타입을 지정해주었습니다. */
        var operator = opParser.parse(opCode);
        var res = operator.operate(first, second);
        recorder.record(res);
    }
}
