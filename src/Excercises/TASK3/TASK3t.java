package Excercises.TASK3;

import java.util.Scanner;

public class TASK3t {
    static void main() {

        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println("Element [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Starting from there: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf(array[i][j] + " ");
            }
        }

        int[] tempRow = array[0];
        array[0] = array[5 - 1];
        array[5 - 1] = tempRow;

        System.out.println("\nAfter changing first and last row: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf(array[i][j] + " ");
            }
        }
        for (int i = 0; i < 5; i++) {
            int tempDiag = array[i][i];
            array[i][i] = array[i][5 - 1 - i];
            array[i][5 - 1 - i] = tempDiag;
        }
        System.out.println("\nAfter changing diagonal: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf(array[i][j] + " ");
            }
        }
    }
}
