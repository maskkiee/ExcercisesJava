package Excercises.TASK3;

import java.util.Scanner;

public class TASK3g {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array's length: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the number: ");
            array[i] = scanner.nextInt();
        }
        int min = array[0];

        for (int i = 1; i < array.length; i++){
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("The minimal number is " + min);
    }

}