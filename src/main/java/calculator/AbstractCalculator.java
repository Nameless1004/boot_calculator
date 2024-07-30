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
    protected final Scanner scanner;

    public AbstractCalculator(OperatorParser operatorParser, Scanner scanner){
        this.scanner = scanner;
        this.operatorParser = operatorParser;
    }


    public AbstractCalculator addSupportOperator(String code, OperatorType type, Operator operator){
        operatorParser.addOperator(code, type, operator);
        return this;
    }

    public final void setSupportOperator(Operator operator) {
        operatable = operator;
    }



}
