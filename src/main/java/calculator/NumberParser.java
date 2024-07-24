package calculator;

public class NumberParser {
    public static Number parse(String input) {
        Number number = null;
        try {
            number = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            try {
                number = Double.parseDouble(input);
            } catch(NumberFormatException e1) {
                try {
                    number = Float.parseFloat(input);
                } catch(NumberFormatException e2) {
                    try {
                        number = Long.parseLong(input);
                    } catch(NumberFormatException e3) {
                        throw e3;
                    }
                }
            }
        }
        return number;
    }
}
