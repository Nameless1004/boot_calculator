package calculator;

public class ArithmeticCalculator extends Calculator{
    private Operatable operator;

    public double calculate(int firstNum, int secondNum, char op) throws Exception{
        operator = switch (op) {
            case '+'-> new AddOperator();
            case '-' -> new SubtractOperator();
            case '*' -> new MultiplyOperator();
            case '/' -> new DivideOperator();
            case '%' -> new ModeOperator();
            default -> throw new Exception("+ - * / 중 하나를 입력해주세요.");
        };

        // 인터페이스를 활용한 다형성으로 구현하였습니다.
        // 나누기의 경우 따로 예외를 던지게 하였습니다.
        result = operator.operate(firstNum,secondNum);
        calcResults.add(result);
        return result;
    }
}
