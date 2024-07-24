package calculator.Operator;

public class ModOperator implements Operatable{
    @Override
    public <T extends Number> T operate(T a, T b) {
        if(a instanceof Double || a instanceof Float || b instanceof Double || b instanceof Float){
            Double d = a.doubleValue() % b.doubleValue();
            return (T)d;
        }
        else {
            Integer i = a.intValue() % b.intValue();
            return (T)i;
        }
    }
}
