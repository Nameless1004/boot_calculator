package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<Integer>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = Integer.parseInt(sc.nextLine());
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNum =  Integer.parseInt(sc.nextLine());
            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.nextLine().charAt(0);

            int result = 0;

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
                        System.out.println("분모는 0이 될 수 없습니다.");
                        return;
                    }
                    result = firstNum / secondNum;
                    break;
                default:
                    System.out.println("+ - * / 중 하나를 입력해주세요.");
                    return;
            }

            System.out.println("결과: " + result);
            // 가장 먼저 저장된 결과를 빼기 위해 FIFO queue 사용
            q.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String input = sc.nextLine();
            if(input.equals("remove")) q.poll();

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            input = sc.nextLine();
            if(input.equals("inquiry")) {
                // 큐 순회하면서 출력
                q.forEach(System.out::println);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            input = sc.nextLine();

            if (input.equals("exit")) {
                return;
            }
        }
    }
}
