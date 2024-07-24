package calculator.Operator;

public class DivideOperator implements Operatable{
    @Override
    public <T extends Number> T operate(T a, T b) throws ArithmeticException {
        if(a instanceof Double || a instanceof Float || b instanceof Double || b instanceof Float){
            if(b.doubleValue() == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
            Double d = a.doubleValue() / b.doubleValue();
            return (T)d;
        }
        else {
            if(b.intValue() == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
            Integer i = a.intValue() / b.intValue();
            return (T)i;
        }
    }
}
