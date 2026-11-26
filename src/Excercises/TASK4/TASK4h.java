package Excercises.TASK4;

public class TASK4h {
    static void main() {
        System.out.println(silniaIter(9));
    }

    private static long silniaIter(int n) {
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
