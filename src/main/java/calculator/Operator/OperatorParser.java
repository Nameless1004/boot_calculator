package calculator.Operator;

import java.util.*;

public class OperatorParser {

    private Map<String, OperatorType> opCodeToOpType;
    private Map<OperatorType, Operator> opTypeToOperator;

    public OperatorParser() {
        opCodeToOpType = new HashMap<>();
        opTypeToOperator = new HashMap<>();
    }

    public OperatorParser addOperator(String opCode, OperatorType type, Operator operator) {
        opCodeToOpType.put(opCode, type);
        opTypeToOperator.put(type, operator);
        return this;
    }


    public Operator parse(String opCode) throws Exception {
        if (!opCodeToOpType.containsKey(opCode)){
            StringBuilder sb = new StringBuilder();
            sb.append(toString());
            sb.append(" 중에 하나를 입력하세요.");
            throw new Exception(sb.toString());
        }
        return opTypeToOperator.get(opCodeToOpType.get(opCode));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(opCodeToOpType.keySet());
        keys.sort(String::compareTo);
        sb.append("[");
        keys.forEach((x)-> sb.append(" " + "'" +x+ "'" + " "));
        sb.append("]");
        return sb.toString();
    }
}
