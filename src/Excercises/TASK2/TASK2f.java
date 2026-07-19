package Excercises.TASK2;

import java.util.Scanner;

public class TASK2f {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int n = s.nextInt();
        while (n >= 0) {
            System.out.println(n);
            n--;
        }
    }
}
