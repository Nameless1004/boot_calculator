package calculator;
import calculator.Operator.OperatorParser;

import java.util.function.Predicate;

public class ArithmeticCalculator extends Calculator{
    public ArithmeticCalculator(){
    }


    private OperatorParser opParser = new OperatorParser();

    public <T extends Number> T calculate(T firstNum, T secondNum, char opCode) throws Exception{
        // 인터페이스를 활용한 다형성으로 구현하였습니다.
        // 나누기의 경우 따로 예외를 던지게 하였습니다.

        /*  자바에서 제네릭에는 원시타입이 들어가지 않고, Integer도 받아야하고 Double도 받아야하므로
            상위 클래스인 Number로 타입을 지정해주었습니다. */
        var operator = opParser.parse(opCode);
        var res = operator.operate(firstNum, secondNum);
        recorder.record(res);
        return (T)res;
    }

    // 람다식으로 조건을 받고 stream()의 filter를 사용해 필터링을 해주었습니다.
    public void inquiryFiltering(Predicate<Number> predicate){
        recorder.stream().filter(predicate).forEach(System.out::println);
    }

}
