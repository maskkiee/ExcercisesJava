package Excercises.TASK3;

import java.util.Arrays;

public class TASK3s {
    static void main() {
        int array [][] = new int[10][10];
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = value++;
            }
        }

        System.out.println("Elements at diagonal: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][i] + " ");
        }
    }
}
