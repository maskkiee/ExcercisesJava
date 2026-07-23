package Excercises.TASK4;

import java.util.Arrays;

public class TASK4n {
    static void main() {
        int[] array = {1, 2, 4, 8, 9, 5, 7, 2, 7, 6};
        int[] array2 = {1, 2, 4, 8, 9, 5, 7, 2, 7, 6};
        System.out.println(Arrays.toString(merge(array, array2)));
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array[array1.length + i] = array2[i];
        }
        return array;
    }
}
