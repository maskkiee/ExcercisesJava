package Excercises.TASK3;

import java.util.Scanner;

public class TASK3h {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array's length: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the number: ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter the number that you want amount of counted: ");
        int numberX = scanner.nextInt();
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberX) {
                counter++;
            }
        }
        System.out.println("Number " + numberX + " exists " + counter + " times in this array.");
    }
}
