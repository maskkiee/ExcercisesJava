package Excercises.TASK2;

import java.util.Scanner;

public class TASK2b {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
