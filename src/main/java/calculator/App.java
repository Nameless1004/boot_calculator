package calculator;

public class App {

    static CircleCalculator circleCalc = new CircleCalculator();
    static ArithmeticCalculator arithmeticCalc = new ArithmeticCalculator();
    static Input input = new Input();

    private static boolean exitApp() {
        if (input.inputString("더 계산하시겠습니까? (exit 입력 시 종료)").equals("exit")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        while (true) {
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
                        CircleAreaCalc();
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
            if (exitApp()) return;
        }
    }

    private static void arithmeticCalc() throws Exception {
        Number firstNum, secondNum;

        firstNum = input.inputNumber("첫 번째 숫자를 입력하세요");
        secondNum = input.inputNumber("두 번째 숫자를 입력하세요");
        char op = input.inputChar("사칙연산 기호를 입력하세요");

        arithmeticCalc.calculate(firstNum, secondNum, op);
        System.out.println("결과: " + arithmeticCalc.getResult());

        if (input.inputString("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)").equals("remove"))
            arithmeticCalc.removeResult();


        if (input.inputString("저장된 연산결과를 조회하시겠습니까? (y 입력 시 조회)").equals("y")) {
            if (input.inputString("저장된 연산결과를 중 n값보다 큰 연산결과를 조회하시겠습니까? (y 입력 시 조회, 아니면 연산결과 조회)").equals("y")) {
                var num = input.inputDouble("n");
                arithmeticCalc.inquiryFiltering((x) -> {
                    return x.doubleValue() > num;
                });
            } else {
                arithmeticCalc.inquiryResults();
            }
        }
    }

    private static void CircleAreaCalc() {
        double radius = input.inputDouble("반지름을 입력하세요");
        circleCalc.calculateCircleArea(radius);
        circleCalc.inquiryResults();
    }
}
