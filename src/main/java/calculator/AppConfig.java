package calculator;

import calculator.Operator.BinaryOperator.*;
import calculator.Operator.OperatorType;
import calculator.Operator.UnaryOperator.*;

public class AppConfig {
    public ICalculator[] calculators(){
        return new ICalculator[]{
                ArithmeticCalculator(),
                CircleAreaCalculator(),
                ScientificCalculator()
        };
    }

    public ICalculator ArithmeticCalculator(){
        ICalculator arithmeticCalculator = new ArithmeticCalculator();
        setArithmeticCalculatorSupprotOperator(arithmeticCalculator);
        return arithmeticCalculator;
    }

    public ICalculator ScientificCalculator(){
        ICalculator scientificCalculator = new ScientificCalculator();
        setScientificCalculatorSupportOperator(scientificCalculator);
        return scientificCalculator;
    }

    public ICalculator CircleAreaCalculator(){
        ICalculator scientificCalculator = new CircleAreaCalculator();
        setCircleAreaCalculatorSupportOperator(scientificCalculator);
        return scientificCalculator;
    }

    public void setArithmeticCalculatorSupprotOperator(ICalculator calculator){
        calculator.addSupportOperator("+", OperatorType.ADD, new AddOperator())
                .addSupportOperator("-", OperatorType.SUB, new SubtractOperator())
                .addSupportOperator("*", OperatorType.MUL, new MultiplyOperator())
                .addSupportOperator("/", OperatorType.DIV, new DivideOperator())
                .addSupportOperator("%", OperatorType.MOD, new ModOperator())
                .addSupportOperator("^", OperatorType.POW, new PowOperator());
    }

    public void setCircleAreaCalculatorSupportOperator(ICalculator calculator){
        calculator.setSupportOperator(new CircleAreaOperator());
    }

    public void setScientificCalculatorSupportOperator(ICalculator calculator){
        calculator.addSupportOperator("+", OperatorType.ADD, new AddOperator())
                .addSupportOperator("-", OperatorType.SUB, new SubtractOperator())
                .addSupportOperator("*", OperatorType.MUL, new MultiplyOperator())
                .addSupportOperator("/", OperatorType.DIV, new DivideOperator())
                .addSupportOperator("%", OperatorType.MOD, new ModOperator())
                .addSupportOperator("^", OperatorType.POW, new PowOperator())
                .addSupportOperator("cos", OperatorType.COS, new CosOperator())
                .addSupportOperator("sin", OperatorType.SIN, new SinOperator())
                .addSupportOperator("tan", OperatorType.TAN, new TanOperator())
                .addSupportOperator("acos", OperatorType.ACOS, new AcosOperator());
    }

}
