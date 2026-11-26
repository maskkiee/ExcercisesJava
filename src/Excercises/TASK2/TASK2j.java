package Excercises.TASK2;

import java.util.Scanner;

public class TASK2j {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int n = s.nextInt();
        for (int i = n; i > 0; i++) {
            if (i % 7 == 0) {
                System.out.println("Najbliższa liczba większa od n podzielna przez 7 to: " + i);
                break;
            }
        }
    }
}
