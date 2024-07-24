package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        CircleCalculator circleCalc = new CircleCalculator();
        ArithmeticCalculator arithmeticCalc = new ArithmeticCalculator();

        while (true) {
            System.out.print("사칙연산:b / 원의 넓이: c 를 입력해주세요: ");
            var type = sc.nextLine().charAt(0);
            if (type == 'b') {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int firstNum = Integer.parseInt(sc.nextLine());
                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNum = Integer.parseInt(sc.nextLine());
                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.nextLine().charAt(0);
                try {
                    arithmeticCalc.calculate(firstNum, secondNum, op);
                    System.out.println("결과: " + arithmeticCalc.getResult());

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    String input = sc.nextLine();
                    if (input.equals("remove")) arithmeticCalc.removeResult();

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    input = sc.nextLine();
                    if (input.equals("inquiry")) {
                        arithmeticCalc.inquiryResults();
                    }

                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    input = sc.nextLine();

                    if (input.equals("exit")) {
                        return;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (type == 'c') {
                System.out.print("반지름을 입력하세요: ");
                float radius = Float.parseFloat(sc.nextLine());
                try {
                    circleCalc.calculateCircleArea(radius);
                    circleCalc.inquiryResults();
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    var input = sc.nextLine();

                    if (input.equals("exit")) {
                        return;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("b 혹은 c 를 입력해주세요.");
            }
        }
    }
}
