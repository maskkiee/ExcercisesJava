package Excercises.TASK9;

import java.util.regex.Pattern;

public final class EmailValidator {
    private EmailValidator() {}

    private static final Pattern EMAIL = Pattern.compile("^[\\\\w.+\\\\-]+@[\\\\w\\\\-]+\\\\.[a-zA-Z]{2,}$");


    public static void validate(String email) {
        if (email == null) {
            throw new EmailIsNull("Email is blank.");
        }
        if (!EMAIL.matcher(email).matches()) {
            throw new InvalidEmailPattern("Invalid email pattern.");
        }
    }
}