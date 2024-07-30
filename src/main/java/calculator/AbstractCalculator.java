package calculator;

import calculator.Operator.Operator;
import calculator.Operator.OperatorParser;
import calculator.Operator.OperatorType;
import calculator.recorder.Recordable;
import calculator.recorder.ResultRecorder;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractCalculator implements ICalculator {

    protected Operator operatable;
    protected final OperatorParser operatorParser;
    protected final Recordable<Number> resultRecorder;
    protected final Scanner scanner;

    public AbstractCalculator(){
        scanner = new Scanner(System.in);
        operatorParser = new OperatorParser();
        resultRecorder = new ResultRecorder();
    }


    public AbstractCalculator addSupportOperator(String code, OperatorType type, Operator operator){
        operatorParser.addOperator(code, type, operator);
        return this;
    }

    public final void setSupportOperator(Operator operator) {
        operatable = operator;
    }

    public final void removeFirstRecordData(){
        resultRecorder.remove();
    }

    public final Number getResult() {
        return resultRecorder.getLatestResult();
    }

    public final void inquiryResults() {
        resultRecorder.stream().forEach(System.out::println);
    }

    public final void inquiryResults(Predicate<Number> predicate) {
        resultRecorder.stream().filter(predicate).forEach(System.out::println);
    }

}
