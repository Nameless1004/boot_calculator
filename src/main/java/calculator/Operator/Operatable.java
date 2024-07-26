package calculator.Operator;

public interface Operatable {
    default double operate(double a){return a;}
    double operate(double a, double b);
}
