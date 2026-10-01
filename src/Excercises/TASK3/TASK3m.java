package Excercises.TASK3;

import java.util.Arrays;

public class TASK3m {
    static void main() {
        int[][] array = new int[3][3];
        int value = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = value;
                value++;
            }
        }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
