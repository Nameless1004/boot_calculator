package calculator;

public class NumberParser {

    public static Number parse(String input) throws NumberFormatException {
        Number number = null;
        if (input == null || input.length() == 0) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        } else if (input.charAt(0) == '-') {
            throw new NumberFormatException("음수는 입력할 수 없습니다.");
        }

        try {
            number = Double.parseDouble(input);
            // number가 정수일 때는 Integer로 바꾸는 처리입니다.
            if (number.doubleValue() % 1 == 0.0) {
                number = number.intValue();
            }
        } catch (NumberFormatException e) {
        }

        if (number == null) {
            throw new NumberFormatException("Number를 입력해주세요.");
        }
        return number;
    }
}
