package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] results = new int[3];
        int index = 0;
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
            if(index == results.length){
                for(int i = 0; i < results.length - 1; i++){
                    // swap
                    int tmp = results[i];
                    results[i] = results[i+1];
                    results[i+1] = tmp;
                }
                results[results.length - 1] = result;
            }
            else{
                results[index++] = result;
            }
            
            System.out.println(Arrays.toString(results));
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.nextLine();

            if (input.equals("exit")) {
                return;
            }
        }
    }
}
