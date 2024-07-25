package calculator;


import calculator.Operator.Operatable;
import calculator.Operator.OperatorParser;

public class CalculatorApplication {

    private final Calculator circleCalc = new CircleCalculator();
    private final Calculator arithmeticCalc = new ArithmeticCalculator();
    private final Input input = new Input();
    private final OperatorParser operatorParser = new OperatorParser();

    public void start(){
        boolean isExit = false;

        while (!isExit) {
            var calcTypeLine = input.inputString("사칙연산:a / 원의 넓이: c 를 입력해주세요");
            if (calcTypeLine.equals("")) {
                continue;
            }
            var type = calcTypeLine.charAt(0);
            try {
                switch (type){
                    case 'a':
                        arithmeticCalc(arithmeticCalc);
                        break;
                    case 'c':
                        circleAreaCalc(circleCalc);
                        break;
                    default:
                        System.out.println("a 혹은 c 를 입력해주세요.");
                        continue;
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            if(input.inputString("더 계산하시겠습니까? (exit 입력 시 종료)").equals("exit")){
                isExit = true;
            }
        }
    }

    private void arithmeticCalc(Calculator currentCalculator) throws Exception {
        Number firstNum, secondNum;

        firstNum = input.inputNumber("첫 번째 숫자를 입력하세요");
        secondNum = input.inputNumber("두 번째 숫자를 입력하세요");
        char op = input.inputChar("사칙연산 기호를 입력하세요");
        Operatable operator = operatorParser.parse(op);
        currentCalculator.setOperator(operator);
        currentCalculator.setOperands(firstNum, secondNum);
        currentCalculator.calculate();

        System.out.println("결과: " + currentCalculator.getResult());

        if (input.inputString("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)").equals("remove"))
            currentCalculator.removeResult();


        if (input.inputString("저장된 연산결과를 조회하시겠습니까? (y 입력 시 조회)").equals("y")) {
            if (input.inputString("저장된 연산결과를 중 n값보다 큰 연산결과를 조회하시겠습니까? (y 입력 시 조회, 아니면 연산결과 조회)").equals("y")) {
                double num = input.inputDouble("n");
                currentCalculator.inquiryFiltering((x) -> {
                    return x.doubleValue() > num;
                });
            } else {
                currentCalculator.inquiryResults();
            }
        }
    }

    private void circleAreaCalc(Calculator currentCalculator) throws Exception {
        double radius = input.inputDouble("반지름을 입력하세요");
        currentCalculator.setOperands(radius);
        currentCalculator.calculate();
        currentCalculator.inquiryResults();
    }

}
