package Excercises.TASK2;

import java.util.Scanner;

public class TASK2n {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbe");
        int n = s.nextInt();
        System.out.println("Podaj drugą liczbe");
        int z = s.nextInt();
        System.out.println("Wszystkie liczby podzielne przez 3 i 5 z tego zakresu to: ");
        for (int i = n; i <= z; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.println(i);
            }
        }
    }
}