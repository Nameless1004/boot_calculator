package calculator;

public class ArithmeticCalculator extends Calculator{
    public double calculate(int firstNum, int secondNum, char op) throws Exception{
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
}
