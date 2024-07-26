package calculator.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorParser {

    private Map<String, OperatorType> opCodeToOpType;
    private Map<OperatorType, Operator> opTypeToOperator;

    public OperatorParser() {
        opCodeToOpType = new HashMap<>();
        opTypeToOperator = new HashMap<>();
    }

    public void addOperator(String opCode, OperatorType type, Operator operator) {
        opCodeToOpType.put(opCode, type);
        opTypeToOperator.put(type, operator);
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
        sb.append("[");
        opCodeToOpType.forEach((x, y)-> sb.append(" " + "'" +x+ "'" + " "));
        sb.append("]");
        return sb.toString();
    }
}
