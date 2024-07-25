package calculator;

public class NumberParser {
    public static Number parse(String input) throws NumberFormatException {
        Number number = null;

        if (input == null || input.length() == 0) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
        else if (input.charAt(0) == '-') {
            throw new NumberFormatException("음수는 입력할 수 없습니다.");
        }

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException e1) {
                try {
                    number = Float.parseFloat(input);
                } catch (NumberFormatException e2) {
                    try {
                        number = Long.parseLong(input);
                    } catch (NumberFormatException e3) {
                        throw e3;
                    }
                }
            }
        }
        return number;
    }
}
