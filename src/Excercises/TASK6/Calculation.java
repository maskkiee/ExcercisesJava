package Excercises.TASK6;

public enum Calculation {
    ADD {
        public double calculate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        public double calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        public double calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        public double calculate(int a, int b) {
            return (double) a / b;
        }
    };

    public abstract double calculate(int a, int b);
}