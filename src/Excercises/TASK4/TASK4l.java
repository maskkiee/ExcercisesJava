package Excercises.TASK4;

public class TASK4l {
    static void main() {
        System.out.println(czyPierwsza(3));
        System.out.println(czyPierwsza(11));
        System.out.println(czyPierwsza(21));
        System.out.println(czyPierwsza(23));

    }

    private static boolean czyPierwsza(int a) {
        if (a == 1) {
            return false;
        }
        for (int i = 2; i * i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
