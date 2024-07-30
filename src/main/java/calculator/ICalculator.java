package calculator;

import calculator.Operator.Operator;
import calculator.Operator.OperatorType;

import java.util.function.Predicate;

public interface ICalculator {
    void input() throws Exception;
    Number calculate()throws Exception;
    void setSupportOperator(Operator operator);
    Number getResult();
    void removeFirstRecordData();
    void inquiryResults();
    void inquiryResults(Predicate<Number> predicate);
    ICalculator addSupportOperator(String code, OperatorType type, Operator operator);
}
