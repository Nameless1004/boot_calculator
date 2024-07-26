package calculator;

import calculator.Operator.Operatable;
import calculator.Operator.OperatorParser;

public class ArithmeticCalculator extends Calculator {

    private final OperatorParser opParser;

    public ArithmeticCalculator() {
        opParser = new OperatorParser();
    }

    @Override
    public void calculate(Object... input) throws Exception {
        if (input.length != 3) {
            throw new Exception("사칙연산을 하기 위해선 (n: Number), (n: Number), (opCode : Character)를 입력해주세요");
        } else if (!(input[0] instanceof Number) || !(input[1] instanceof Number) || !(input[2] instanceof Character)) {
            throw new Exception("사칙연산을 하기 위해선 (n: Number), (n: Number), (opCode : Character)를 입력해주세요");
        }

        char opCode = (char) input[2];
        Operatable operator = opParser.parse(opCode);
        var res = operator.operate((Number) input[0], (Number) input[1]);
        recorder.record(res);
    }
}
