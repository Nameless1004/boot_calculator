package calculator;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public Number inputNumber(String desc) {
        printDescription(desc);
        return NumberParser.parse(scanner.nextLine());
    }

    public double inputDouble(String desc) {
        printDescription(desc);
        return Double.parseDouble(scanner.nextLine());
    }
    public char inputChar(String desc) {
        printDescription(desc);
        return scanner.nextLine().charAt(0);
    }

    public String inputString(String desc) {
        printDescription(desc);
        return scanner.nextLine();
    }

    private void printDescription(String desc) {
        System.out.print(desc + " : ");
    }
}
