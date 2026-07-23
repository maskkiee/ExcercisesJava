package Excercises.TASK4;

public class TASK4i {
    static void main() {
        System.out.println(silniaRek(9));
    }

    public static long silniaRek(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * silniaRek(n - 1);
    }
}
