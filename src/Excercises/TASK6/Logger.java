package Excercises.TASK6;

public enum Logger {
    INSTANCE;

    public void log(String message) {
        System.out.println(message);
    }
}
