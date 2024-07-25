package calculator;

public class CircleCalculator extends Calculator{
    private double radius;

    @Override
    public void setOperator(char operator) {
        throw new UnsupportedOperationException("지원하지 않습니다.");
    }

    @Override
    public void calculate() throws Exception {
        var res = PI * radius * radius;
        recorder.record(res);
    }

    @Override
    public void setOperands(Number... nums) {
        radius = nums[0].doubleValue();
    }
}
