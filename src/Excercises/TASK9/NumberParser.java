package Excercises.TASK9;

final class NumberParser {
    static int parsePositiveInt(String s) {
        int value;
        try {
            value = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid number: " + s + " ", e);
        }
        if (value <= 0) {
            throw new IllegalArgumentException("non-positive: " + value);
        }
        return value;
    }
}