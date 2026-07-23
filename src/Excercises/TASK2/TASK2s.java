package Excercises.TASK2;

import java.util.Scanner;

public class TASK2s {
    static void main() {
        Scanner s = new Scanner(System.in);
        int max = 0;
        while (true) {
            System.out.println("Podaj następną liczbe. 0 kończy działanie");
            int n = s.nextInt();
            if (n > max) {
                max = n;
            }
            if (n == 0) {
                System.out.println("Najwyższa liczba to: " + max);
                break;
            }
        }
    }
}
