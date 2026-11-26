package Excercises.TASK9;

//Unchecked bo walidacja to problem po stronie użytkownika/domeny, a nie kompilatora.
public class EmailValidationException extends RuntimeException {
    public EmailValidationException(String message) {
        super(message);
    }
}
