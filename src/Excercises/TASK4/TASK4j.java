package Excercises.TASK4;

public class TASK4j {
    static void main() {
        int[] array = {1, 2, 4, 8, 9, 5, 7, 2, 7, 6};
        System.out.println(sumaTablicy(array));
    }

    private static int sumaTablicy(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
