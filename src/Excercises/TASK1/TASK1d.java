package Excercises.TASK1;

import java.util.Scanner;

public class TASK1d {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj temperature (Celsius): ");
        int n = s.nextInt();
        if (n < 0) {
            System.out.println("Mróz.");
        } else if (n < 15) {
            System.out.println("Chłodno.");
        } else if (n < 25)
            System.out.println("Ciepło.");
        else
            System.out.println("Gorąco.");
    }
}