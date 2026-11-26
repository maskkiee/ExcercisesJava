package Excercises.TASK3;

import java.util.Arrays;

public class TASK3k {
    static void main() {
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] array3 = new int[array.length];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = array[i] + array2[i];
        }
        System.out.println(Arrays.toString(array3));
    }
}
