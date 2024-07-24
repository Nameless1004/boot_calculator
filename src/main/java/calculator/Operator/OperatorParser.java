package calculator.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorParser {
    public OperatorParser(){
        init();
    }

    private Map<Character, OperatorType> opCodeToOpType;
    private Map<OperatorType, Operatable> opTypeToOperator;

    private void init(){
        initOpCodeToOpType();
        initOpTypeToOperator();
    }

    private void initOpCodeToOpType(){
        opCodeToOpType = new HashMap<>();
        opCodeToOpType.put('+', OperatorType.ADD);
        opCodeToOpType.put('-', OperatorType.SUB);
        opCodeToOpType.put('*', OperatorType.MUL);
        opCodeToOpType.put('/', OperatorType.DIV);
        opCodeToOpType.put('%', OperatorType.MOD);
    }

    private void initOpTypeToOperator(){
        opTypeToOperator = new HashMap<>();
        opTypeToOperator.put(OperatorType.ADD, new AddOperator());
        opTypeToOperator.put(OperatorType.SUB, new SubtractOperator());
        opTypeToOperator.put(OperatorType.MUL, new MultiplyOperator());
        opTypeToOperator.put(OperatorType.DIV, new DivideOperator());
        opTypeToOperator.put(OperatorType.MOD, new ModOperator());
    }

    public Operatable parse(char opCode) throws Exception {
        if(!opCodeToOpType.containsKey(opCode)) throw new Exception("+ - * / % 중에 하나를 입력하세요.");
        return opTypeToOperator.get(opCodeToOpType.get(opCode));
    }
}
