package calculator.Operator;

public interface Operatable{
    <T extends Number> T operate(T a, T b);
}
