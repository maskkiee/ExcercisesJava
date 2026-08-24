package Excercises.TASK4;

public class TASK4d {
    static void main() {
        czyParzysta(8);

    }

    private static boolean czyParzysta(int a) {
        if (a % 2 == 0) {
            System.out.println("Number is even.");
            return true;
        } else {
            System.out.println("Number isn't even.");
            return false;
        }
    }
}
