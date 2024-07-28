package calculator;

import calculator.Operator.Operator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractCalculator {

    public AbstractCalculator(){
        resultRecorder = new ResultRecorder();
        scanner = new Scanner(System.in);
    }

    protected final ResultRecorder resultRecorder;
    protected final Scanner scanner;
    protected Operator operatable;

    public abstract void initOperators();
    public abstract void input() throws Exception;
    public abstract Number calculate() throws Exception;

    protected final Number getResult() {
        return resultRecorder.getLatestResult();
    }

    protected final void inquiryResults() {
        resultRecorder.stream().forEach(System.out::println);
    }

    protected final void inquiryResults(Predicate<Number> predicate) {
        resultRecorder.stream().filter(predicate).forEach(System.out::println);
    }

    protected final void removeHead() {
        resultRecorder.remove();
    }

    protected final void resetResults() {
        resultRecorder.reset();
    }

    protected final  ArrayList<Number> getResults() {
        return (ArrayList<Number>)resultRecorder.stream().toList();
    }
}
