package Excercises.TASK4;

public class TASK4g {
    static void main() {
        int x = 5;
        System.out.println("X is: " + x);
        zmienX(x);
        System.out.println("After method in main X is: " + x);
    }

    private static void zmienX(int x) {
        x = 10;
        System.out.println("In method x is: " + x);
    }
}
