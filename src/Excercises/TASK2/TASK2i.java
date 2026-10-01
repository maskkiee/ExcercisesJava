package Excercises.TASK2;

import java.util.Scanner;

public class TASK2i {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int n = s.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
