package Excercises.TASK2;

import java.util.Scanner;

public class TASK2h {
    static void main() {
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.println("Podaj liczbe dodatnią");
            n = s.nextInt();
        } while (n < 0); {
            System.out.println("Udało się.");
        }
    }
}
