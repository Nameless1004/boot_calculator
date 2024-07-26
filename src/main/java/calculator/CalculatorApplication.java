package calculator;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorApplication {

    private final Calculator circleCalc = new CircleAreaCalculator();
    private final Calculator arithmeticCalc = new ArithmeticCalculator();
    boolean isExit = false;
    Scanner scanner = new Scanner(System.in);

    Map<Integer, Calculator> calculators;

    public CalculatorApplication() {
        calculators = new HashMap<>();
        init();
    }

    private void init() {
        initializeCalculators();
    }

    private void initializeCalculators() {
        calculators.put(1,new ArithmeticCalculator());
        calculators.put(2,new CircleAreaCalculator());
    }

    public void start() {
        isExit = false;
        while (!isExit) {
            update();
        }
    }

    private void showCalculators(){
        System.out.println("--------------------");
        calculators.forEach((x, y)->{
            System.out.println("[ "+x+" ]" + " : " + y.getClass().getSimpleName());
        });
        System.out.println("--------------------");
    }

    public void update() {
        System.out.println("계산기를 선택해주세요.");
        showCalculators();
        System.out.print("선택(번호 입력): ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if(!calculators.containsKey(num)) {
                System.out.println("1 부터 " + calculators.size() +" 사이의 숫자만 입력해주세요.");
                return;
            }


            Calculator currentFunction;
            try {
                currentFunction = calculators.get(num);
                currentFunction.onUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }

            System.out.print("계산을 종료하시겠습니까? (exit: 종료): ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                isExit = true;
            }
        }  catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }
}
