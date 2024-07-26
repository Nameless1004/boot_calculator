package calculator.Operator;

public interface Operatable {

    <T extends Number> double operate(T a, T b);
}
