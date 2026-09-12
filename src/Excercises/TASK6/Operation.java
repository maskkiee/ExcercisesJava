package Excercises.TASK6;

public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    public double calculate(int a, int b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return (double) a / b;
        }
        return 0;
    }
}