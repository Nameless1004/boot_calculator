package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNum = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNum = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char op = sc.next().charAt(0);

        int result = 0;

        switch (op){
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
                if(secondNum == 0) {
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
    }
}
