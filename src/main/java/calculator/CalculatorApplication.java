package calculator;


public class CalculatorApplication {
    private Calculator currentCalculator;
    private final CircleCalculator circleCalc = new CircleCalculator();
    private final ArithmeticCalculator arithmeticCalc = new ArithmeticCalculator();
    private final Input input = new Input();

    public void start(){
        boolean isExit = false;

        while (isExit == false) {
            var calcTypeLine = input.inputString("사칙연산:a / 원의 넓이: c 를 입력해주세요");
            if (calcTypeLine.equals("")) {
                continue;
            }
            var type = calcTypeLine.charAt(0);
            try {
                switch (type){
                    case 'a':
                        arithmeticCalc();
                        break;
                    case 'c':
                        circleAreaCalc();
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
            isExit = exitApp();
        }
    }

    private boolean exitApp() {
        return input.inputString("더 계산하시겠습니까? (exit 입력 시 종료)").equals("exit");
    }

    private void arithmeticCalc() throws Exception {
        currentCalculator = arithmeticCalc;
        Number firstNum, secondNum;

        firstNum = input.inputNumber("첫 번째 숫자를 입력하세요");
        secondNum = input.inputNumber("두 번째 숫자를 입력하세요");
        char op = input.inputChar("사칙연산 기호를 입력하세요");

        currentCalculator.setOperator(op);
        currentCalculator.setOperands(firstNum, secondNum);
        currentCalculator.calculate();

        System.out.println("결과: " + currentCalculator.getResult());

        if (input.inputString("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)").equals("remove"))
            currentCalculator.removeResult();


        if (input.inputString("저장된 연산결과를 조회하시겠습니까? (y 입력 시 조회)").equals("y")) {
            if (input.inputString("저장된 연산결과를 중 n값보다 큰 연산결과를 조회하시겠습니까? (y 입력 시 조회, 아니면 연산결과 조회)").equals("y")) {
                var num = input.inputDouble("n");
                currentCalculator.inquiryFiltering((x) -> {
                    return x.doubleValue() > num;
                });
            } else {
                currentCalculator.inquiryResults();
            }
        }
    }

    private void circleAreaCalc() throws Exception {
        double radius = input.inputDouble("반지름을 입력하세요");
        currentCalculator = circleCalc;
        currentCalculator.setOperands(radius);
        currentCalculator.calculate();
        currentCalculator.inquiryResults();
    }

}
