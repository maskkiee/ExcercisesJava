package Excercises.TASK4;

public class TASK4e {
    static void main() {
        double avg = srednia(5, 7, 10);
        String result = String.format("%.2f", avg);
        System.out.println(result);
    }

    public static double srednia(double a, double b, double c) {
        return (a + b + c) / 3;

    }
}
