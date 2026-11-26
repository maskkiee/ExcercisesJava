package Excercises.TASK9;

public final class PasswordValidator {
    private PasswordValidator() {
    }

    public static void validate(String pwd) {
        if (pwd == null || pwd.length() < 8) {
            throw new IllegalArgumentException("Password length should be at least 8 characters");
        }
        if (!pwd.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password should contain at least one digit character");
        }
        ;
    }
}