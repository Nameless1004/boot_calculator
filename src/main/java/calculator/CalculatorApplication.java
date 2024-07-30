package calculator;

import calculator.recorder.Recordable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class CalculatorApplication {
    private boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);
    private AppConfig config = new AppConfig();

    private ICalculator currentCalculator;
    private final Map<Integer, ICalculator> calculators;
    private final Map<ICalculator, Recordable<Number>> resultRecorder;

    public CalculatorApplication() {
        calculators = new HashMap<>();
        resultRecorder = new HashMap<>();

        initializeCalculators();
    }


    private void initializeCalculators() {
        ICalculator[] supportCalculators = config.calculators();

        for(int i = 0; i < supportCalculators.length; ++i){
            calculators.put(i+1, supportCalculators[i]);
            resultRecorder.put(supportCalculators[i], config.recorder());
        }
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
        try {
            System.out.println("계산기를 선택해주세요.");

            showCalculators();

            System.out.print("선택(번호 입력): ");
            int num = Integer.parseInt(scanner.nextLine());

            if(!calculators.containsKey(num)) {
                System.out.println("1 부터 " + calculators.size() +" 사이의 숫자만 입력해주세요.");
                return;
            }

            try {
                currentCalculator = calculators.get(num);
                currentCalculator.input();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }

            Number result = currentCalculator.calculate();
            record(result);

            System.out.println("결과 : " + getResult());

            System.out.print("맨 처음 결과를 삭제하시겠습니까? (remove: 삭제): ");
            String input = scanner.nextLine();

            if (input.equals("remove")) {
                removeFirstRecordData();
            }

            System.out.print("결과들을 출력하시겠습니까? (y: 출력, 그 외: 출력안함): ");
            input = scanner.nextLine();
            if(input.equals("y")){
                System.out.print("n수 보다 큰 결과물들만 출력하시겠습니까? (y: 큰 수만 출력, 그 외: 출력): ");
                input = scanner.nextLine();
                if(input.equals("y")) {
                    System.out.print("n: ");
                    double n = Double.parseDouble(scanner.nextLine());
                    inquiryResults((x) -> x.doubleValue() > n);
                }
                else {
                    inquiryResults();
                }
            }

            System.out.print("계산을 종료하시겠습니까? (exit: 종료): ");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                isExit = true;
            }
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void record(Number result){
        resultRecorder.get(currentCalculator).record(result);
    }

    public void removeFirstRecordData(){
        resultRecorder.get(currentCalculator).remove();
    }

    public Number getResult() {
        return resultRecorder.get(currentCalculator).getLatestResult();
    }

    public void inquiryResults() {
        resultRecorder.get(currentCalculator).stream().forEach(System.out::println);
    }

    public final void inquiryResults(Predicate<Number> predicate) {
        resultRecorder.get(currentCalculator).stream().filter(predicate).forEach(System.out::println);
    }
}
