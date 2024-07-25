package calculator;

import calculator.Operator.Operatable;

public class CircleCalculator extends Calculator{
    private double radius;

    @Override
    public void setOperator(Operatable operator) {
        throw new UnsupportedOperationException("지원하지 않습니다.");
    }

    @Override
    public void calculate() throws Exception {
        double res = PI * radius * radius;
        recorder.record(res);
    }

    @Override
    public void setOperands(Number... nums) throws Exception{
        if(nums.length != 1) throw new Exception("필요 피연산자의 개수는 1개 입니다.");
        radius = nums[0].doubleValue();
    }
}
