package Excercises.TASK3;

import java.util.Scanner;

public class TASK3f {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array's length: ");
        int length = scanner.nextInt();
        int max = 0;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the number: ");
            array[i] = scanner.nextInt();
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("The maximum number is " + max);

    }
}