package Excercises.TASK4;

import java.util.Arrays;

public class TASK4m {
    static void main() {
        int[] array = {1, 2, 4, 8, 9, 5, 7, 2, 7, 6};
        System.out.println(Arrays.toString(odwrocTablice(array)));
    }

    private static int[] odwrocTablice(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length - i - 1];
        }
        return newArray;
    }
}
