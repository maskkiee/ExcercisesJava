package Excercises.TASK4;

public class TASK4k {
    static void main() {
        int[] array = {1, 2, 4, 8, 9, 5, 7, 2, 7, 6};
        System.out.println(maxTablicy(array));
    }

    private static int maxTablicy(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
