package calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public abstract class Calculator {

    public Calculator(){
        resultRecorder = new ResultRecorder();
        scanner = new Scanner(System.in);
    }

    protected ResultRecorder resultRecorder;
    protected Scanner scanner;

    public abstract void onUpdate() throws Exception;

    protected Number calculate(Number num) throws Exception {
        throw new Exception("지원하지 않는 기능입니다.");
    }

    protected Number calculate(Number num, Number num2, char op) throws Exception {
        throw new Exception("지원하지 않는 기능입니다.");
    }

    protected Number getResult() {
        return resultRecorder.getLatestResult();
    }

    protected void inquiryResults() {
        resultRecorder.stream().forEach(System.out::println);
    }

    protected void inquiryResults(Predicate<Number> predicate) {
        resultRecorder.stream().filter(predicate).forEach(System.out::println);
    }

    protected void removeHead() {
        resultRecorder.remove();
    }

    protected void resetResults() {
        resultRecorder.reset();
    }

    protected ArrayList<Number> getResults() {
        return (ArrayList<Number>)resultRecorder.stream().toList();
    }
}
