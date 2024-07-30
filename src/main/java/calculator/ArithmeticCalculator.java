package calculator;

import calculator.Operator.BinaryOperator.*;

public class ArithmeticCalculator extends AbstractCalculator {
    private Number firstNumber;
    private Number secondNumber;

    @Override
    public void input() throws Exception {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        firstNumber = NumberParser.parse(scanner.nextLine());

        System.out.print(operatorParser.toString() + "를 입력하세요: ");
        String op = scanner.nextLine();

        // operatorParser 객체에게 파싱 요청
        operatable = operatorParser.parse(op);

        if(operatable instanceof BinaryOperator){
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNumber = NumberParser.parse(scanner.nextLine());
        } else {
            secondNumber = null;
        }
    }

    @Override
    public Number calculate() {
        Number num;
        if(operatable instanceof BinaryOperator){
            num = operatable.operate(firstNumber.doubleValue(), secondNumber.doubleValue());
        } else {
          num = operatable.operate(firstNumber.doubleValue());
        }

        resultRecorder.record(num);
        return resultRecorder.getLatestResult();
    }

}
