package calculator;

import calculator.Operator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ArithmeticCalculator extends Calculator{
    public ArithmeticCalculator(){
        operator = new HashMap<>();
        opCodeMap = new HashMap<>();
        initOperator();
    }

    private void initOperator() {
        opCodeMap.put('+', OperatorType.ADD);
        opCodeMap.put('-', OperatorType.SUB);
        opCodeMap.put('*', OperatorType.MUL);
        opCodeMap.put('/', OperatorType.DIV);
        opCodeMap.put('%', OperatorType.MOD);

        // 오퍼레이터타입을 키, 오퍼레이터 객체를 값으로 하는 맵 생성
        // 이후 사용 시 map에서 해당 키에 해당하는 오퍼레이터를 가져와서 연산
        operator.put(OperatorType.ADD, new AddOperator());
        operator.put(OperatorType.SUB, new SubtractOperator());
        operator.put(OperatorType.MUL, new MultiplyOperator());
        operator.put(OperatorType.DIV, new DivideOperator());
        operator.put(OperatorType.MOD, new ModOperator());
    }

    private Map<Character, OperatorType> opCodeMap;
    private Map<OperatorType, Operatable> operator;

    public OperatorType getOperatorType(char opCode) throws Exception{
        if(!opCodeMap.containsKey(opCode)) throw new Exception("+ - * / % 중에 하나를 입력하세요.");
        return opCodeMap.get(opCode);
    }

    public <T extends Number> T calculate(T firstNum, T secondNum, char opCode) throws Exception{
        // 인터페이스를 활용한 다형성으로 구현하였습니다.
        // 나누기의 경우 따로 예외를 던지게 하였습니다.

        /*
            자바에서 제네릭에는 원시타입이 들어가지 않고, Integer도 받아야하고 Double도 받아야하므로
            상위 클래스인 Number로 타입을 지정해주었습니다.
         */
        result = operator.get(getOperatorType(opCode)).operate(firstNum, secondNum);
        calcResults.add(result);
        return (T)result;
    }

    // 람다식으로 조건을 받고 stream()의 filter를 사용해 필터링을 해주었습니다.
    public void inquiryFiltering(Predicate<Number> predicate){
        calcResults.stream().filter(predicate).forEach(System.out::println);
    }

}
