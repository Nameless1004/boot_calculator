package calculator;

import calculator.Operator.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class ArithmeticCalculator extends Calculator {

    private Operatable operatable;
    private OperatorParser operatorParser;

    public ArithmeticCalculator() {
        operatorParser = new OperatorParser();
        operatorParser.addOperator('+', OperatorType.ADD, new AddOperator());
        operatorParser.addOperator('-', OperatorType.SUB, new SubtractOperator());
        operatorParser.addOperator('*', OperatorType.MUL, new MultiplyOperator());
        operatorParser.addOperator('/', OperatorType.DIV, new DivideOperator());
        operatorParser.addOperator('%', OperatorType.MOD, new ModOperator());
        operatorParser.addOperator('^', OperatorType.MOD, new PowOperator());
    }

    @Override
    public void onUpdate() throws Exception {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        Number firstNumber = NumberParser.parse(scanner.nextLine());

        System.out.print("두 번째 숫자를 입력하세요: ");
        Number secondNumber = NumberParser.parse(scanner.nextLine());

        System.out.print(operatorParser.toString() + "를 입력하세요: ");
        char op = scanner.nextLine().charAt(0);

        calculate(firstNumber, secondNumber, op);

        System.out.println("결과 : " + resultRecorder.getLatestResult());

        System.out.print("맨 처음 결과를 삭제하시겠습니까? (remove: 삭제): ");
        String input = scanner.nextLine();

        if (input.equals("remove")) {
            removeHead();
        }

        System.out.print("결과들을 출력하시겠습니까? (y: 출력, 그 외: 출력안함): ");
        input = scanner.nextLine();
        if(input.equals("y")){
            System.out.print("n수 보다 큰 결과물들만 출력하시겠습니까? (y: 큰 수만 출력, 그 외: 출력): ");
            input = scanner.nextLine();
            if(input.equals("y")) {
                System.out.print("n: ");
                double n = Double.parseDouble(scanner.nextLine());
                inquiryResults((x) -> (double) x > n);
            }
            else {
                inquiryResults();
            }
        }
    }

    @Override
    protected Number calculate(Number num1, Number num2, char op)  throws Exception {

        double firstNum = num1.doubleValue();
        double secondNum = num2.doubleValue();
        operatable = operatorParser.parse(op);
        operatable.operate(firstNum, secondNum);
        resultRecorder.record(operatable.operate(firstNum, secondNum));

        return resultRecorder.getLatestResult();
    }

}
